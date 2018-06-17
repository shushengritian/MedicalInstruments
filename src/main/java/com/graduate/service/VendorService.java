package com.graduate.service;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;

/**
 * @author xiyouquedongxing
 * @date 2018/6/10 15:33
 */
public interface VendorService {

    /***/
    JSONObject listVendor(String id, String vName, String oibc, String vType, String status,
                          String pageNo, String pageSize);

    /***/
    JSONObject add(String vNo, String vName, String oibc, String salesman, String phone, String vType,
                   String status);

    /***/
    JSONObject getVendorById(String id);

    /***/
    JSONObject editById(String id, String vNo, String vName, String oibc, String salesman, String phone,
                        String vType, String status);

    /***/
    JSONObject delById(String id);

    /***/
    JSONObject uploadExcel(FileItem fi);
}
