package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.*;
import com.kgc.kmall.manager.mapper.PmsBaseAttrInfoMapper;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog1Mapper;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog2Mapper;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog3Mapper;
import com.kgc.kmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-16 16:45
 */
@Component
@Service
public class CatalogServiceImpl implements CatalogService {
    @Resource
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Resource
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Resource
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> selectAll() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Mapper.selectByExample(null);
        return pmsBaseCatalog1s;
    }

    @Override
    public List<PmsBaseCatalog2> selectAllBycatalog1Id(Integer catalog1Id) {
        PmsBaseCatalog2Example example=new PmsBaseCatalog2Example();
        PmsBaseCatalog2Example.Criteria criteria = example.createCriteria();
        if(catalog1Id!=null){
            criteria.andCatalog1IdEqualTo(catalog1Id);
        }
        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.selectByExample(example);
        return pmsBaseCatalog2s;
    }


    @Override
    public List<PmsBaseCatalog3> selectAllBycatalog2Id(Integer catalog2Id) {
        PmsBaseCatalog3Example example=new PmsBaseCatalog3Example();
        PmsBaseCatalog3Example.Criteria criteria = example.createCriteria();
        if(catalog2Id!=null){
            criteria.andCatalog2IdEqualTo(catalog2Id);
        }
        List<PmsBaseCatalog3> pmsBaseCatalog3s = pmsBaseCatalog3Mapper.selectByExample(example);
        return pmsBaseCatalog3s;
    }
    }

