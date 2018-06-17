package com.graduate.service;

import net.sf.json.JSONObject;

/**
 * @author xiyouquedongxing
 * @date 2018/6/11 15:16
 */
public interface StockService {

    /***/
    JSONObject listSupplies(String hcNo, String hcName, String pageNo, String pageSize);

    /***/
    JSONObject inStock(String hcNo, String singleNo, String number, String sType, String validDate);

    /***/
    JSONObject outStock(String hcNo, String singleNo, String number, String sType, String validDate);

    /***/
    JSONObject listAccessStock(String startDate, String endDate, String hcName, String sType,
                               String pageNo, String pageSize);

}
