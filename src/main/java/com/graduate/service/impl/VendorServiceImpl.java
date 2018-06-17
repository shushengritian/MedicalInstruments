package com.graduate.service.impl;

import com.graduate.dao.VendorMapper;
import com.graduate.model.Vendor;
import com.graduate.model.VendorExample;
import com.graduate.model.VendorExample.Criteria;
import com.graduate.service.VendorService;
import com.graduate.tools.poi.ReadExcel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author xiyouquedongxing
 * @date 2018/6/10 15:34
 */
@Service("vendorService")
public class VendorServiceImpl extends BaseImpl implements VendorService {

    @Resource
    private VendorMapper vendorMapper;


    @Override
    public JSONObject listVendor(String id, String vName, String oibc, String vType, String status,
                                 String pageNo, String pageSize) {
        Map<String,Object> map = new HashMap<>(8);
        //查询所有数据
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        if (StringUtils.isNotBlank(vName)) {
            map.put("vName",vName);
        }
        if (StringUtils.isNotBlank(oibc)) {
            map.put("oibc",oibc);
        }
        if (StringUtils.isNotBlank(vType)) {
            map.put("vType",vType);
        }
        if (StringUtils.isNotBlank(status)) {
            map.put("status",status);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<Vendor> list = vendorMapper.selectByMap(map);
        JSONArray data = JSONArray.fromObject(list);
        //查询数据条数
        int count = vendorMapper.countByMap(map);

        return selectResult(count, data);
    }

    @Override
    public JSONObject add(String vNo, String vName, String oibc, String salesman, String phone, String vType,
                          String status) {
        Vendor vendor = new Vendor();
        if (StringUtils.isNotBlank(vNo)) {
            vendor.setvNo(vNo);
        }
        if (StringUtils.isNotBlank(vName)) {
            vendor.setvName(vName);
        }
        if (StringUtils.isNotBlank(oibc)) {
            vendor.setOibc(oibc);
        }
        if (StringUtils.isNotBlank(salesman)) {
            vendor.setSalesman(salesman);
        }
        if (StringUtils.isNotBlank(phone)) {
            vendor.setPhone(phone);
        }
        if (StringUtils.isNotBlank(vType)) {
            vendor.setvType(Byte.parseByte(vType));
        }
        if (StringUtils.isNotBlank(status)) {
            vendor.setStatus(Byte.parseByte(status));
        }
        vendor.setCreateTime(new Date());
        vendor.setModifiedTime(new Date());
        int res = vendorMapper.insert(vendor);
        return addResult(res);
    }

    @Override
    public JSONObject getVendorById(String id) {
        Map<String,Object> map = new HashMap<>(1);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        List<Vendor> list = vendorMapper.selectByMap(map);
        JSONObject data = JSONArray.fromObject(list).getJSONObject(0);
        return getByIdResult(data);
    }

    @Override
    public JSONObject editById(String id, String vNo, String vName, String oibc, String salesman, String phone,
                               String vType, String status) {
        VendorExample example = new VendorExample();
        Vendor vendor = new Vendor();
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(id)) {
            criteria.andIdEqualTo(Long.parseLong(id));
            vendor.setId(Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(vNo)) {
            vendor.setvNo(vNo);
        }
        if (StringUtils.isNotBlank(vName)) {
            vendor.setvName(vName);
        }
        if (StringUtils.isNotBlank(oibc)) {
            vendor.setOibc(oibc);
        }
        if (StringUtils.isNotBlank(salesman)) {
            vendor.setSalesman(salesman);
        }
        if (StringUtils.isNotBlank(phone)) {
            vendor.setPhone(phone);
        }
        if (StringUtils.isNotBlank(vType)) {
            vendor.setvType(Byte.parseByte(vType));
        }
        if (StringUtils.isNotBlank(status)) {
            vendor.setStatus(Byte.parseByte(status));
        }
        vendor.setModifiedTime(new Date());
        int res = vendorMapper.updateByExample(vendor, example);
        return editByIdResult(res);
    }

    @Override
    public JSONObject delById(String id) {
        int res = vendorMapper.deleteByPrimaryKey(Long.parseLong(id));
        return delByIdResult(res);
    }

    @Override
    public JSONObject uploadExcel(FileItem fi) {
        //厂商信息表格上传
        ReadExcel readExcel = new ReadExcel();
        List<String> keyList = new ArrayList<>();
        keyList.add("vNo");
        keyList.add("vName");
        keyList.add("oibc");
        keyList.add("salesman");
        keyList.add("phone");
        JSONArray array = readExcel.getExcelInfo(fi, 1, keyList);
        boolean isSuccess = false;
        if (array != null && array.size() > 0) {
            List<Vendor> list = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Vendor vendor = new Vendor();
                vendor.setvNo(obj.optString("vNo"));
                vendor.setvName(obj.optString("vName"));
                vendor.setOibc(obj.optString("oibc"));
                vendor.setSalesman(obj.optString("salesman"));
                vendor.setPhone(obj.optString("phone"));
                vendor.setStatus((byte)1);
                vendor.setCreateTime(new Date());
                vendor.setModifiedTime(new Date());
                list.add(vendor);
            }
            int i = vendorMapper.insertBatch(list);
            if (i > 0) {
                isSuccess = true;
            }
        }
        return booleanResult(isSuccess);
    }
}
