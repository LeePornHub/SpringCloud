package com.liyh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@ComponentScan
@FeignClient(value ="LUCKYLOTTERY")
public interface BaseDataFeign {
    @GetMapping("/test/getPort")
    public String getPort();
}
