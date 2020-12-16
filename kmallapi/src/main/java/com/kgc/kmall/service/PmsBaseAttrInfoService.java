package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-16 16:23
 */
public interface PmsBaseAttrInfoService {
    List<PmsBaseAttrInfo> selectAll(Integer catalog3Id);
    Integer add(PmsBaseAttrInfo pmsBaseAttrInfo);
}
