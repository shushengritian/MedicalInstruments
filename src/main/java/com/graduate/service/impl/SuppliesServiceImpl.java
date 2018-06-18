package com.graduate.service.impl;

import com.graduate.dao.StockMapper;
import com.graduate.dao.SuppliesMapper;
import com.graduate.model.Stock;
import com.graduate.model.Supplies;
import com.graduate.model.SuppliesExample;
import com.graduate.model.SuppliesExample.Criteria;
import com.graduate.model.Vendor;
import com.graduate.service.SuppliesService;
import com.graduate.tools.poi.ReadExcel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author xiyouquedongxing
 * @date 2018/6/8 21:53
 */
@Service("suppliesService")
public class SuppliesServiceImpl extends BaseImpl implements SuppliesService {

    @Resource
    private SuppliesMapper suppliesMapper;

    @Resource
    private StockMapper stockMapper;

    @Override
    public JSONObject listSupplies(String id, String hcNo, String hcName, String manafacturer, String pageNo,
                                   String pageSize) {
        Map<String,Object> map = new HashMap<>(8);
        //查询所有数据
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        if (StringUtils.isNotBlank(hcNo)) {
            map.put("hcNo",hcNo);
        }
        if (StringUtils.isNotBlank(hcName)) {
            map.put("hcName",hcName);
        }
        if (StringUtils.isNotBlank(manafacturer)) {
            map.put("manafacturer",manafacturer);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<Supplies> list = suppliesMapper.selectByMap(map);
        JSONArray data = JSONArray.fromObject(list);
        //查询数据条数
        int count = suppliesMapper.countByMap(map);

        return selectResult(count, data);
    }

    @Override
    public JSONObject add(String hcNo, String hcName, String manafacturer, String unit, String hcType, String price) {
        Supplies supplies = new Supplies();
        if (StringUtils.isNotBlank(hcNo)) {
            supplies.setHcNo(hcNo);
        }
        if (StringUtils.isNotBlank(hcName)) {
            supplies.setHcName(hcName);
        }
        if (StringUtils.isNotBlank(manafacturer)) {
            supplies.setManafacturer(manafacturer);
        }
        if (StringUtils.isNotBlank(unit)) {
            supplies.setUnit(Byte.parseByte(unit));
        }
        if (StringUtils.isNotBlank(hcType)) {
            supplies.setHcType(Byte.parseByte(hcType));
        }
        if (StringUtils.isNotBlank(price)) {
            supplies.setPrice(new BigDecimal(price));
        }
        supplies.setCreateTime(new Date());
        supplies.setModifiedTime(new Date());
        int res = suppliesMapper.insert(supplies);
        Stock stock = new Stock();
        stock.setNo(hcNo);
        stock.setStock(0);
        stock.setCreateTime(new Date());
        stock.setModifiedTime(new Date());
        stockMapper.insert(stock);
        return addResult(res);
    }



    @Override
    public JSONObject getSuppliesById(String id) {
        Map<String,Object> map = new HashMap<>(1);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        List<Supplies> list = suppliesMapper.selectByMap(map);
        JSONObject data = JSONArray.fromObject(list).getJSONObject(0);
        return getByIdResult(data);
    }

    @Override
    public JSONObject editById(String id, String hcNo, String hcName, String manafacturer, String unit,
                               String hcType, String price) {
        SuppliesExample example = new SuppliesExample();
        Supplies supplies = new Supplies();
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(id)) {
            criteria.andIdEqualTo(Long.parseLong(id));
            supplies.setId(Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(hcNo)) {
            supplies.setHcNo(hcNo);
        }
        if (StringUtils.isNotBlank(hcName)) {
            supplies.setHcName(hcName);
        }
        if (StringUtils.isNotBlank(manafacturer)) {
            supplies.setManafacturer(manafacturer);
        }
        if (StringUtils.isNotBlank(unit)) {
            supplies.setUnit(Byte.parseByte(unit));
        }
        if (StringUtils.isNotBlank(hcType)) {
            supplies.setHcType(Byte.parseByte(hcType));
        }
        if (StringUtils.isNotBlank(price)) {
            supplies.setPrice(new BigDecimal(price));
        }
        supplies.setModifiedTime(new Date());
        int res = suppliesMapper.updateByExample(supplies, example);
        return editByIdResult(res);
    }

    @Override
    public JSONObject delById(String id) {
        int res = suppliesMapper.deleteByPrimaryKey(Long.parseLong(id));
        return delByIdResult(res);
    }

    @Override
    public JSONObject uploadExcel(FileItem fi) {
        //器械信息表格上传
        ReadExcel readExcel = new ReadExcel();
        List<String> keyList = new ArrayList<>();
        keyList.add("hcNo");
        keyList.add("hcName");
        keyList.add("manafacturer");
        keyList.add("hcType");
        keyList.add("unit");
        keyList.add("price");
        JSONArray array = readExcel.getExcelInfo(fi, 1, keyList);
        boolean isSuccess = false;
        if (array != null && array.size() > 0) {
            List<Supplies> list = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Supplies supplies = new Supplies();
                supplies.setHcNo(obj.optString("hcNo"));
                supplies.setHcName(obj.optString("hcName"));
                supplies.setManafacturer(obj.optString("manafacturer"));
                supplies.setHcType(Byte.parseByte(obj.optString("hcType")));
                String unit = getUnit(obj.optString("unit"));
                supplies.setUnit(Byte.parseByte(unit));
                supplies.setPrice(new BigDecimal(obj.optString("price")));
                supplies.setCreateTime(new Date());
                supplies.setModifiedTime(new Date());
                list.add(supplies);
            }
            int i = suppliesMapper.insertBatch(list);
            if (i > 0) {
                isSuccess = true;
            }
        }
        return booleanResult(isSuccess);
    }

    private String getUnit(String unitStr) {
        if ("个".equals(unitStr)) {
            return "1";
        } else if ("包".equals(unitStr)) {
            return "2";
        } else if ("袋".equals(unitStr)) {
            return "3";
        } else if ("台".equals(unitStr)) {
            return "4";
        } else if ("箱".equals(unitStr)) {
            return "5";
        } else if ("条".equals(unitStr)) {
            return "6";
        } else if ("只".equals(unitStr)) {
            return "7";
        } else if ("瓶".equals(unitStr)) {
            return "8";
        } else if ("床".equals(unitStr)) {
            return "9";
        }
        return "1";
    }



}
