package com.graduate.service.impl;

import com.graduate.dao.SuppliesMapper;
import com.graduate.model.Supplies;
import com.graduate.model.SuppliesExample;
import com.graduate.model.SuppliesExample.Criteria;
import com.graduate.service.SuppliesService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/6/8 21:53
 */
@Service("suppliesService")
public class SuppliesServiceImpl extends BaseImpl implements SuppliesService {

    @Resource
    private SuppliesMapper suppliesMapper;

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
}
