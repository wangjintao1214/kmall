package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrInfoExample;
import com.kgc.kmall.bean.PmsBaseAttrValue;
import com.kgc.kmall.bean.PmsBaseAttrValueExample;
import com.kgc.kmall.manager.mapper.PmsBaseAttrInfoMapper;
import com.kgc.kmall.manager.mapper.PmsBaseAttrValueMapper;
import com.kgc.kmall.service.AttrService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-17 11:08
 */
@Component
@Service
public class AttrServiceImpl implements AttrService{
    @Resource
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Resource
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Override
    public List<PmsBaseAttrInfo> selectAll(Integer catalog3Id) {
        PmsBaseAttrInfoExample example=new PmsBaseAttrInfoExample();
        PmsBaseAttrInfoExample.Criteria criteria = example.createCriteria();
        if(catalog3Id!=null){
            criteria.andCatalog3IdEqualTo(catalog3Id);
        }
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.selectByExample(example);
        return pmsBaseAttrInfos;
    }

    @Override
    public Integer add(PmsBaseAttrInfo pmsBaseAttrInfo) {
        int i=0;
        //判断是添加还是修改
        if (pmsBaseAttrInfo.getId()==null){
            //添加
            i = pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
        }else{
            //修改
            i=pmsBaseAttrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
        }
        //删除原属性值
        PmsBaseAttrValueExample example=new PmsBaseAttrValueExample();
        PmsBaseAttrValueExample.Criteria criteria = example.createCriteria();
        criteria.andAttrIdEqualTo(pmsBaseAttrInfo.getId());
        i = pmsBaseAttrValueMapper.deleteByExample(example);
        //添加新属性值
        if (pmsBaseAttrInfo.getAttrValueList().size()>0){
            i=pmsBaseAttrValueMapper.insertBatch(pmsBaseAttrInfo.getId(),pmsBaseAttrInfo.getAttrValueList());
        }
        return i;
    }

    @Override
    public List<PmsBaseAttrValue> seleByattrId(Long attrId) {
        PmsBaseAttrValueExample example=new PmsBaseAttrValueExample();
        PmsBaseAttrValueExample.Criteria criteria = example.createCriteria();
        if(attrId!=null){
            criteria.andAttrIdEqualTo(attrId);
        }
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.selectByExample(example);
        return pmsBaseAttrValues;
    }
}
