package com.mohannad.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
/**
 *  registry.addViewController("/home").setViewName("home");
 *       registry.addViewController("/").setViewName("home");
 *       registry.addViewController("/hello").setViewName("hello");
 *       registry.addViewController("/login").setViewName("login");
 */
    @RequestMapping({"/home" , "/"} )
    public String getHome(){
        return "home";
    }


    @RequestMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }
}
