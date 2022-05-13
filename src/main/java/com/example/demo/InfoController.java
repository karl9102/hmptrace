package com.example.demo;

import com.example.demo.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangY
 * @date: 2022/04/19
 * @description:
 */
@RestController
@Slf4j
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("sen")
    public String add(String id) {

        return infoService.getInfo(id);
    }

}
