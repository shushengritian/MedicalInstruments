package com.graduate.service;

import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/4/26 22:44
 */
public interface ExternalService {

    /**
     * 获取全部外部订单号
     * */
    Map<String,String> listExternalOrderId(Map<String,String> map);
}
