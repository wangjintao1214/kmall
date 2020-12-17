package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsProductInfo;
import com.kgc.kmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-17 11:49
 */
@CrossOrigin
@RestController
public class SpuController {
    @Reference
    SpuService spuService;
    @RequestMapping("/spuList")
    public List<PmsProductInfo> spuList(Long catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.selectAllBycatalog3Id(catalog3Id);
        for (PmsProductInfo pmsProductInfo : pmsProductInfos) {
            System.out.println(pmsProductInfo.toString());
        }
        return pmsProductInfos;
    }
}
