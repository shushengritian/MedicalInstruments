package com.graduate.service;

import net.sf.json.JSONObject;

/**
 * @author xiyouquedongxing
 * @date 2018/6/10 21:47
 */
public interface ContractService {

    /** */
    JSONObject listContract(String partyB, String cName, String cType, String startDate, String endDate,
                            String pageNo, String pageSize);

    /** */
    JSONObject add(String cNo, String cName, String cType, String partyB, String bContacts, String phone,
                   String signedDate, String endDate, String content);

    /***/
    JSONObject getContractById(String id);

    /***/
    JSONObject editById(String id, String cNo, String cName, String cType, String partyB, String bContacts,
                        String phone, String signedDate, String endDate, String content);

    /***/
    JSONObject delById(String id);
}
