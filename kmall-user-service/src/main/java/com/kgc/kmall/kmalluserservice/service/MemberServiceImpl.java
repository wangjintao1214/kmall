package com.kgc.kmall.kmalluserservice.service;

import com.kgc.kmall.bean.Member;
import com.kgc.kmall.kmalluserservice.mapper.MemberMapper;
import com.kgc.kmall.service.MemberService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-15 16:13
 */
@Component
@Service
public class MemberServiceImpl implements MemberService{
    @Resource
    MemberMapper memberMapper;

    @Override
    public List<Member> selectAll() {
        List<Member> members = memberMapper.selectByExample(null);
        return members;
    }
}
