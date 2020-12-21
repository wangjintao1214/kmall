package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.PmsBaseSaleAttr;
import com.kgc.kmall.bean.PmsProductInfo;
import com.kgc.kmall.bean.PmsProductInfoExample;
import com.kgc.kmall.manager.mapper.PmsBaseSaleAttrMapper;
import com.kgc.kmall.manager.mapper.PmsProductInfoMapper;
import com.kgc.kmall.service.SpuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-17 11:47
 */
@Component
@Service
public class SpuServiceImpl implements SpuService{

    @Resource
    PmsProductInfoMapper pmsProductInfoMapper;
    @Resource
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsProductInfo> selectAllBycatalog3Id(Long catalog3Id) {
        PmsProductInfoExample example=new PmsProductInfoExample();
        PmsProductInfoExample.Criteria criteria = example.createCriteria();
        if(catalog3Id!=null){
            criteria.andCatalog3IdEqualTo(catalog3Id);
        }
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.selectByExample(example);
        return pmsProductInfos;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrMapper.selectByExample(null);
        return pmsBaseSaleAttrs;
    }
}
