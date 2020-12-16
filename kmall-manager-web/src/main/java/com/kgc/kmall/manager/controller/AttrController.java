package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.service.PmsBaseAttrInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-16 17:08
 */
/*跨域*/
@CrossOrigin
@RestController
public class AttrController {

    @Reference
    PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(Integer catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoService.selectAll(catalog3Id);
        for (PmsBaseAttrInfo pmsBaseAttrInfo : pmsBaseAttrInfos) {
            System.out.println(pmsBaseAttrInfo.toString());
        }
        return pmsBaseAttrInfos;
    }
    @RequestMapping("/saveAttrInfo")
    public Integer saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        int i = pmsBaseAttrInfoService.add(pmsBaseAttrInfo);
        return i;
    }

}

