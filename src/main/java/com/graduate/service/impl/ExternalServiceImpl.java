package com.graduate.service.impl;

import com.graduate.service.ExternalService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/4/26 22:45
 */
@Service("externalService")
public class ExternalServiceImpl implements ExternalService {

    @Override
    public Map<String, String> listExternalOrderId(Map<String,String> map) {
        return null;
    }
}
