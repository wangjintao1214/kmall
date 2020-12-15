package com.kgc.kmall.kmalluserservice.service;

import com.kgc.kmall.bean.Member;
import com.kgc.kmall.kmalluserservice.mapper.MemberMapper;
import com.kgc.kmall.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-15 16:13
 */
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
