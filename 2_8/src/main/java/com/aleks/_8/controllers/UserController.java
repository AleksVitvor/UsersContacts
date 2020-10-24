package com.aleks._8.controllers;

import FrontModels.FrontUserForLogging;
import Services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller(value = "/user")
public class UserController {
    private final LoginService loginService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(LoginService service) {
        loginService = service;
    }

    @PostMapping(value = {"/register"})
    public ModelAndView Register(FrontUserForLogging userForLogging) {
        logger.debug("register");
        ModelAndView modelAndView = new ModelAndView();
        loginService.Register(userForLogging.toUserRegistration());
        return modelAndView;
    }
}
