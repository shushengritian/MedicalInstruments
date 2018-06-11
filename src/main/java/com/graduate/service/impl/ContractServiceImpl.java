package com.graduate.service.impl;

import com.graduate.dao.ContractMapper;
import com.graduate.model.Contract;
import com.graduate.model.ContractExample;
import com.graduate.model.ContractExample.Criteria;
import com.graduate.service.ContractService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.json.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/6/10 21:47
 */
@Service("contractService")
public class ContractServiceImpl extends BaseImpl implements ContractService {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Resource
    private ContractMapper contractMapper;

    @Override
    public JSONObject listContract(String partyB, String cName, String cType, String startDate, String endDate, String pageNo, String pageSize) {
        Map<String,Object> map = new HashMap<>(8);
        //查询所有数据
        if (StringUtils.isNotBlank(partyB)) {
            map.put("partyB",partyB);
        }
        if (StringUtils.isNotBlank(cName)) {
            map.put("cName",cName);
        }
        if (StringUtils.isNotBlank(cType)) {
            map.put("cType",cType);
        }
        if (StringUtils.isNotBlank(startDate)) {
            map.put("startDate",startDate);
        }
        if (StringUtils.isNotBlank(endDate)) {
            map.put("endDate",endDate);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<Contract> list = contractMapper.selectByMap(map);
        getListGson().toJson(list);
        String str = getListGson().toJson(list);
        JSONArray data = JSONArray.fromObject(str);
        //查询数据条数
        int count = contractMapper.countByMap(map);

        return selectResult(count, data);
    }

    @Override
    public JSONObject add(String cNo, String cName, String cType, String partyB, String bContacts,
                          String phone, String signedDate, String endDate, String content) {
        Contract contract = new Contract();
        if (StringUtils.isNotBlank(cNo)) {
            contract.setcNo(cNo);
        }
        if (StringUtils.isNotBlank(cName)) {
            contract.setcName(cName);
        }
        if (StringUtils.isNotBlank(cType)) {
            contract.setcType(Byte.parseByte(cType));
        }
        if (StringUtils.isNotBlank(partyB)) {
            contract.setPartyB(partyB);
        }
        if (StringUtils.isNotBlank(bContacts)) {
            contract.setbContacts(bContacts);
        }
        if (StringUtils.isNotBlank(phone)) {
            contract.setPhone(phone);
        }
        if (StringUtils.isNotBlank(signedDate)) {
            try {
                contract.setSignedDate(format.parse(signedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(endDate)) {
            try {
                contract.setEndDate(format.parse(endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(content)) {
            contract.setContent(content);
        }
        contract.setCreateTime(new Date());
        contract.setModifiedTime(new Date());
        int res = contractMapper.insert(contract);
        return addResult(res);
    }

    @Override
    public JSONObject getContractById(String id) {
        Map<String,Object> map = new HashMap<>(1);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        List<Contract> list = contractMapper.selectByMap(map);
        String str = getListGson().toJson(list);
        JSONArray array = JSONArray.fromObject(str);
        JSONObject data = array.getJSONObject(0);
        return getByIdResult(data);
    }

    @Override
    public JSONObject editById(String id, String cNo, String cName, String cType, String partyB,
                               String bContacts, String phone, String signedDate, String endDate,
                               String content) {
        ContractExample example = new ContractExample();
        Contract contract = new Contract();
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(id)) {
            criteria.andIdEqualTo(Long.parseLong(id));
            contract.setId(Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(cNo)) {
            contract.setcNo(cNo);
        }
        if (StringUtils.isNotBlank(cName)) {
            contract.setcName(cName);
        }
        if (StringUtils.isNotBlank(cType)) {
            contract.setcType(Byte.parseByte(cType));
        }
        if (StringUtils.isNotBlank(partyB)) {
            contract.setPartyB(partyB);
        }
        if (StringUtils.isNotBlank(bContacts)) {
            contract.setbContacts(bContacts);
        }
        if (StringUtils.isNotBlank(phone)) {
            contract.setPhone(phone);
        }
        if (StringUtils.isNotBlank(signedDate)) {
            try {
                contract.setSignedDate(format.parse(signedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(endDate)) {
            try {
                contract.setEndDate(format.parse(endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(content)) {
            contract.setContent(content);
        }
        contract.setModifiedTime(new Date());
        int res = contractMapper.updateByExample(contract, example);
        return editByIdResult(res);
    }

    @Override
    public JSONObject delById(String id) {
        int res = contractMapper.deleteByPrimaryKey(Long.parseLong(id));
        return delByIdResult(res);
    }
}
