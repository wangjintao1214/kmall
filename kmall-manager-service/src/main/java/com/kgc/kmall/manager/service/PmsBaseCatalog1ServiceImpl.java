package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.PmsBaseCatalog1;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog1Mapper;
import com.kgc.kmall.service.PmsBaseCatalog1Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-16 15:23
 */
@Service
@Component
public class PmsBaseCatalog1ServiceImpl implements PmsBaseCatalog1Service{

    @Resource
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Override
    public List<PmsBaseCatalog1> selectAll() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Mapper.selectByExample(null);
        return pmsBaseCatalog1s;
    }
}
