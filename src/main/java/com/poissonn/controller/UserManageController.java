package com.poissonn.controller;


import com.poissonn.dto.PoissonnUserDto;
import com.poissonn.service.UserManageService;
import com.poissonn.util.ResultInfo;
import com.poissonn.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
@Api(value = "用户相关的api")
public class UserManageController {


    @Autowired
    UserManageService userManageService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录" ,  notes="登录")
    public String login(@ApiParam(value = "用户名") @RequestParam(name = "username") String username,
                        @ApiParam(value = "密码") @RequestParam(name = "password") String password){
        System.out.println(username+"============="+password);
        return "index.html";
        //return userManageService.login(username,password);
    }

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUser( @RequestBody PoissonnUserDto dto){
        ResultInfo info = new ResultInfo();
        Boolean rel = userManageService.addUser(dto);
        return info;
    }


    /**
     * 查询
     * @param username
     * @return
     */
    @ApiOperation(value = "根据用户名搜索用户" ,  notes="根据用户名搜索用户")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo query(@ApiParam(value = "用户名") @RequestParam(name = "username") String username,
                            @ApiParam(value = "昵称") @RequestParam(name = "name") String name){
        List<PoissonnUserDto> list = userManageService.query(username,name);
        if (list == null || list.size() <= 0)
            return ResultUtil.getFailureResult();
        return ResultUtil.getSuccessResult(list,list.size());
    }



}
