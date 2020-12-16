package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseCatalog1;
import com.kgc.kmall.service.PmsBaseCatalog1Service;
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
    PmsBaseCatalog1Service pmsBaseCatalog1Service;
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Service.selectAll();
        for (PmsBaseCatalog1 pmsBaseCatalog1 : pmsBaseCatalog1s) {
            System.out.println(pmsBaseCatalog1.toString());
        }
        return pmsBaseCatalog1s;
    }

}
