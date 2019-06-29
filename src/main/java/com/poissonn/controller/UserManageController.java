package com.poissonn.controller;


import com.poissonn.dto.PoissonnUserDto;
import com.poissonn.service.UserManageService;
import com.poissonn.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@Api(tags = "用户相关的api")
public class UserManageController extends BaseController{


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
        return super.process(() -> {
            userManageService.addUser(dto);
            return null;
        });
    }


    /**
     * 查询
     * @param map
     * @return
     */
    @ApiOperation(value = "根据用户名搜索用户" ,  notes="根据用户名搜索用户")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo query(@RequestBody Map<String,String> map){
        return super.process(() -> {
            return userManageService.query(map);
        });
    }



    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo delete(@RequestParam(value = "id") Integer id){
        return super.process(() -> {
            userManageService.delete(id);
            return null;
        });
    }


    /**
     * 给权限下拉框动态赋值
     * @return
     */
    @ApiOperation(value = "获取当前所有权限节点" ,  notes="获取当前所有权限节点")
    @RequestMapping(value = "/role",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo getRole(){
        return super.process(() -> {
            return userManageService.getRole();
        });
    }


}
