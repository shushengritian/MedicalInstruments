package com.graduate.service;

import net.sf.json.JSONObject;

/**
 * @author xiyouquedongxing
 * @date 2018/6/6 23:17
 */
public interface DeviceService {

    /**
     * 查询设备列表
     * */
    JSONObject listDevice(String id, String deviceNo, String deviceName, String deviceType, String isMeasurement,
                          String status, String pageNo, String pageSize);

    /**
     *
     * */
    JSONObject add(String deviceNo, String deviceName, String unit, String deviceType, String isMeasurement,
                        String status);

    /***/
    JSONObject getDeviceById(String id);

    /***/
    JSONObject editById(String id, String deviceNo, String deviceName, String unit, String deviceType,
                        String isMeasurement, String status);

    /***/
    JSONObject delById(String id);
}
