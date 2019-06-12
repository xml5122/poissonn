package com.poissonn.controller;


import com.poissonn.dto.PoissonnUserDto;
import com.poissonn.service.UserManageService;
import com.poissonn.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(value = "用户相关的api")
public class UserManageController {


    @Autowired
    UserManageService userManageService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){

        System.out.println(username+"============="+password);


        return "index.html";

        //return userManageService.login(username,password);

    }

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUser( @RequestBody PoissonnUserDto dto){
        ResultInfo info = new ResultInfo();
        Boolean rel = userManageService.addUser(dto);
        return info;
    }


    @ApiOperation(value = "测试swagger" ,  notes="测试swagger")
    @RequestMapping(value = "/action",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        //ModelAndView mv =  new ModelAndView("login.html");
        return "hello";
    }


}
