package com.example.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author: wangY
 * @date: 2022/04/19
 * @description:
 */
@Service
public class InfoServiceImpl implements InfoService {

    @SentinelResource(value = "getInfo")
    @Override
    public String getInfo(String info) {
        return info+"--SentinelResource";
    }
}
