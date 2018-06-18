package com.graduate.service;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;

/**
 * @author xiyouquedongxing
 * @date 2018/6/8 21:53
 */
public interface SuppliesService {

    /**
     * 查询设备列表
     * */
    JSONObject listSupplies(String id, String hcNo, String hcName, String manafacturer, String pageNo,
                            String pageSize);

   /**
     *
     * */
    JSONObject add(String hcNo, String hcName, String manafacturer, String unit, String hcType, String price);

    /***/
    JSONObject getSuppliesById(String id);

    /***/
    JSONObject editById(String id, String hcNo, String hcName, String manafacturer, String unit, String hcType,
                        String price);

    /***/
    JSONObject delById(String id);

    /***/
    JSONObject uploadExcel(FileItem fi);

}
