package com.liyh.controller;

import com.liyh.feign.BaseDataFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/baseData")
public class BaseDataController {
    @Value("${eurewka.cliewnt}")
    private String configInfo;
    @Autowired
    private BaseDataFeign baseDataFeign;

    @GetMapping("/getStr")
    public Object getStr() {
        return baseDataFeign.getPort();
    }

    @PostMapping("/getConfig")
    public Object getConfig() {
        return configInfo;
    }
}
