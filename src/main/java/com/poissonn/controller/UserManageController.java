package com.poissonn.controller;


import com.poissonn.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManageController {


    @Autowired
    UserManageService userManageService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){

        System.out.println(username+"============="+password);


        return "index.html";

        //return userManageService.login(username,password);

    }


    @RequestMapping(value = "/action",method = RequestMethod.GET)
    public String index(){
        //ModelAndView mv =  new ModelAndView("login.html");
        return "redirect:/index.html";
    }


}
