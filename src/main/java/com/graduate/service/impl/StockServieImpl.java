package com.graduate.service.impl;

import com.graduate.dao.AccessStockMapper;
import com.graduate.dao.StockMapper;
import com.graduate.dao.SuppliesMapper;
import com.graduate.model.*;
import com.graduate.model.StockExample.Criteria;
import com.graduate.service.StockService;
import com.graduate.service.SuppliesService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/6/11 15:17
 */
@Service("stockService")
public class StockServieImpl extends BaseImpl implements StockService {

    @Resource
    private SuppliesMapper suppliesMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private AccessStockMapper accessStockMapper;

    private Stock stock;
    @Override
    public JSONObject listSupplies(String hcNo, String hcName, String pageNo, String pageSize) {
        Map<String,Object> map = new HashMap<>(4);
        //查询所有数据
        if (StringUtils.isNotBlank(hcNo)) {
            map.put("hcNo",hcNo);
        }
        if (StringUtils.isNotBlank(hcName)) {
            map.put("hcName",hcName);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<SuppliesStock> list = stockMapper.selectByMap(map);
        JSONArray data = JSONArray.fromObject(list);
        //查询数据条数
        int count = stockMapper.countByMap(map);

        return selectResult(count, data);
    }

    @Override
    public JSONObject inStock(String hcNo, String singleNo, String number, String sType) {
        //入库操作，查询库存
        Supplies supplies = suppliesMapper.selectByHcNo(hcNo);
        AccessStock accessStock = new AccessStock();
        accessStock.setSingleNo(singleNo);
        accessStock.setsType(Byte.parseByte(sType));
        accessStock.setHcNo(hcNo);
        accessStock.setNumber(Integer.parseInt(number));
        BigDecimal numberL = new BigDecimal(number);
        BigDecimal amount = numberL.multiply(supplies.getPrice());
        accessStock.setAmount(amount);
        accessStock.setInOrOut((byte)1);
        accessStock.setCreateTime(new Date());
        accessStock.setModifiedTime(new Date());
        int ai = accessStockMapper.insert(accessStock);
        int si = 0;
        stock = stockMapper.selectByHcNo(hcNo);
        if (stock != null) {
            int num = stock.getStock() + Integer.parseInt(number);
            stock.setStock(num);
            stock.setModifiedTime(new Date());
            si = stockMapper.updateByPrimaryKey(stock);
        } else {
            stock.setNo(hcNo);
            stock.setStock(Integer.parseInt(number));
            stock.setCreateTime(new Date());
            stock.setModifiedTime(new Date());
            si = stockMapper.insert(stock);
        }
        return aiAndSi(ai, si);
    }

    @Override
    public JSONObject outStock(String hcNo, String singleNo, String number, String sType) {
        //出库操作，查询库存
        stock = stockMapper.selectByHcNo(hcNo);
        int num = stock.getStock() - Integer.parseInt(number);
        if (num < 0) {
            JSONObject obj = new JSONObject();
            obj.put("code","0");
            obj.put("msg","库存不足！");
        }
        stock.setStock(num);
        stock.setModifiedTime(new Date());
        int si = stockMapper.updateByPrimaryKey(stock);

        Supplies supplies = suppliesMapper.selectByHcNo(hcNo);
        AccessStock accessStock = new AccessStock();
        accessStock.setSingleNo(singleNo);
        accessStock.setsType(Byte.parseByte(sType));
        accessStock.setHcNo(hcNo);
        accessStock.setNumber(Integer.parseInt(number));
        BigDecimal numberL = new BigDecimal(number);
        BigDecimal amount = numberL.multiply(supplies.getPrice());
        accessStock.setAmount(amount);
        accessStock.setInOrOut((byte)2);
        accessStock.setCreateTime(new Date());
        accessStock.setModifiedTime(new Date());
        int ai = accessStockMapper.insert(accessStock);
        return aiAndSi(ai, si);
    }

    @Override
    public JSONObject listAccessStock(String startDate, String endDate, String hcName, String sType,
                                      String pageNo, String pageSize) {
        Map<String,Object> map = new HashMap<>(4);
        //查询所有数据
        if (StringUtils.isNotBlank(startDate)) {
            map.put("startDate",startDate);
        }
        if (StringUtils.isNotBlank(endDate)) {
            map.put("endDate",endDate);
        }

        if (StringUtils.isNotBlank(hcName)) {
            map.put("hcName",hcName);
        }
        if (StringUtils.isNotBlank(sType)) {
            map.put("sType",sType);
        }

        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<AccessStock> list = accessStockMapper.selectByMap(map);
        String str = getListGson().toJson(list);
        JSONArray data = JSONArray.fromObject(str);
        //查询数据条数
        int count = accessStockMapper.countByMap(map);

        return selectResult(count, data);
    }
}
