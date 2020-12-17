package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsProductInfo;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-17 11:45
 */
public interface SpuService {
    List<PmsProductInfo> selectAllBycatalog3Id(Long catalog3Id);
}
