package com.aleks._8.controllers;

import FrontModels.FrontUserForLogging;
import Services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller(value="/user")
public class UserController {
    @Autowired
    private LoginService loginService;

    Logger logger = LoggerFactory.getLogger(UserController.class);



    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView Register(FrontUserForLogging userForLogging)
    {
        ModelAndView modelAndView=new ModelAndView();
        loginService.Register(userForLogging.toUserRegistration());
        return modelAndView;
    }
}
