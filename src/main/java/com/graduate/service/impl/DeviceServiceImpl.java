package com.graduate.service.impl;

import com.graduate.dao.DeviceMapper;
import com.graduate.model.Device;
import com.graduate.model.DeviceExample;
import com.graduate.model.DeviceExample.Criteria;
import com.graduate.service.DeviceService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/6/6 23:18
 */
@Service("deviceService")
public class DeviceServiceImpl extends BaseImpl implements DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public JSONObject listDevice(String id, String deviceNo, String deviceName, String deviceType,
                                 String isMeasurement, String status, String pageNo, String pageSize) {
        Map<String,Object> map = new HashMap<>(8);
        //查询所有数据
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        if (StringUtils.isNotBlank(deviceNo)) {
            map.put("deviceNo",deviceNo);
        }
        if (StringUtils.isNotBlank(deviceName)) {
            map.put("deviceName",deviceName);
        }
        if (StringUtils.isNotBlank(deviceType)) {
            map.put("deviceType",deviceType);
        }
        if (StringUtils.isNotBlank(isMeasurement)) {
            map.put("isMeasurement",isMeasurement);
        }
        if (StringUtils.isNotBlank(status)) {
            map.put("status",status);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<Device> list = deviceMapper.selectByMap(map);
        JSONArray data = JSONArray.fromObject(list);
        //查询数据条数
        int count = deviceMapper.countByMap(map);

        return selectResult(count, data);
    }

    @Override
    public JSONObject add(String deviceNo, String deviceName, String unit, String deviceType,
                          String isMeasurement, String status) {
        Device device = new Device();
        if (StringUtils.isNotBlank(deviceNo)) {
            device.setDeviceNo(deviceNo);
        }
        if (StringUtils.isNotBlank(deviceName)) {
            device.setDeviceName(deviceName);
        }
        if (StringUtils.isNotBlank(unit)) {
            device.setUnit(Byte.parseByte(unit));
        }
        if (StringUtils.isNotBlank(deviceType)) {
            device.setDeviceType(Byte.parseByte(deviceType));
        }
        if (StringUtils.isNotBlank(isMeasurement)) {
            device.setIsMeasurement(Byte.parseByte(isMeasurement));
        }
        if (StringUtils.isNotBlank(status)) {
            device.setStatus(Byte.parseByte(status));
        }
        device.setCreateTime(new Date());
        device.setModifiedTime(new Date());
        int res = deviceMapper.insert(device);
        return addResult(res);
    }

    @Override
    public JSONObject getDeviceById(String id) {
        Map<String,Object> map = new HashMap<>(1);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        List<Device> list = deviceMapper.selectByMap(map);
        JSONObject data = JSONArray.fromObject(list).getJSONObject(0);
        return getByIdResult(data);
    }

    @Override
    public JSONObject editById(String id, String deviceNo, String deviceName, String unit, String deviceType,
                               String isMeasurement, String status) {
        DeviceExample example = new DeviceExample();
        Device device = new Device();
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(id)) {
            criteria.andIdEqualTo(Long.parseLong(id));
            device.setId(Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(deviceNo)) {
            device.setDeviceNo(deviceNo);
        }
        if (StringUtils.isNotBlank(deviceName)) {
            device.setDeviceName(deviceName);
        }
        if (StringUtils.isNotBlank(unit)) {
            device.setUnit(Byte.parseByte(unit));
        }
        if (StringUtils.isNotBlank(deviceType)) {
            device.setDeviceType(Byte.parseByte(deviceType));
        }
        if (StringUtils.isNotBlank(isMeasurement)) {
            device.setIsMeasurement(Byte.parseByte(isMeasurement));
        }
        if (StringUtils.isNotBlank(status)) {
            device.setStatus(Byte.parseByte(status));
        }
        device.setModifiedTime(new Date());
        int res = deviceMapper.updateByExample(device, example);
        return editByIdResult(res);
    }

    @Override
    public JSONObject delById(String id) {
        int res = deviceMapper.deleteByPrimaryKey(Long.parseLong(id));
        return delByIdResult(res);
    }

}
