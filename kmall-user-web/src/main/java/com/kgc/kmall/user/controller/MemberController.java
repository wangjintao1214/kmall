package com.kgc.kmall.user.controller;

import com.kgc.kmall.bean.Member;
import com.kgc.kmall.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-12-15 17:12
 */
@RestController
@Api(tags = "用户相关接口",description = "提供用户相关的Rest API")
public class MemberController {
    @Reference
    MemberService memberService;

    @ApiOperation("用户查询接口")
    @PostMapping(value = "/index",produces = "application/json;charset=UTF-8")
    public List<Member> toindex(){
        return memberService.selectAll();
    }
}
