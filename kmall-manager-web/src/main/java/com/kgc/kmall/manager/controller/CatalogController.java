package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseCatalog1;
import com.kgc.kmall.bean.PmsBaseCatalog2;
import com.kgc.kmall.bean.PmsBaseCatalog3;
import com.kgc.kmall.service.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-16 15:31
 */
@CrossOrigin
@RestController
public class CatalogController {
    @Reference
    CatalogService catalogService;

    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> pmsBaseCatalog1s = catalogService.selectAll();
        for (PmsBaseCatalog1 pmsBaseCatalog1 : pmsBaseCatalog1s) {
            System.out.println(pmsBaseCatalog1.toString());
        }
        return pmsBaseCatalog1s;
    }
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id){
        List<PmsBaseCatalog2> pmsBaseCatalog2s = catalogService.selectAllBycatalog1Id(catalog1Id);
        for (PmsBaseCatalog2 pmsBaseCatalog2 : pmsBaseCatalog2s) {
            System.out.println(pmsBaseCatalog2.toString());
        }
        return pmsBaseCatalog2s;
    }
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Integer catalog2Id){
        List<PmsBaseCatalog3> pmsBaseCatalog3s = catalogService.selectAllBycatalog2Id(catalog2Id);
        for (PmsBaseCatalog3 pmsBaseCatalog3 : pmsBaseCatalog3s) {
            System.out.println(pmsBaseCatalog3.toString());
        }
        return pmsBaseCatalog3s;
    }


}
