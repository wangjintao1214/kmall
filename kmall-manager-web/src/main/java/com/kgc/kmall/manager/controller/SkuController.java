package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsSkuInfo;
import com.kgc.kmall.service.SkuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2020-12-23 15:44
 */
@CrossOrigin
@RestController
public class SkuController {
    @Reference
    SkuService skuService;

    @RequestMapping("/saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo skuInfo){
        String result  = skuService.saveSkuInfo(skuInfo);
        return result ;
    }

}
