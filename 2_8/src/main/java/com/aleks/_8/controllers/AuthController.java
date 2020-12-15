package com.aleks._8.controllers;

import com.aleks._8.BLL.Services.LoginService;
import com.aleks._8.DAL.FrontModels.AuthLogin;
import com.aleks._8.DAL.FrontModels.AuthResponse;
import com.aleks._8.DAL.FrontModels.FrontUserForLogging;
import com.aleks._8.DAL.FrontModels.UserNameOnly;
import com.aleks._8.DAL.ServiceModels.UserRegistrationVM;
import com.aleks._8.config.jwt.JwtProvider;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Log
public class AuthController {
    private static final Logger logger=Logger.getLogger(AuthController.class.getName());
    @Autowired
    private LoginService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public void registerUser(@RequestBody FrontUserForLogging registrationRequest) {
        userService.Register(UserRegistrationVM.ToRegistrationVM(registrationRequest));
        logger.info("register");
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthLogin request) {
        UserNameOnly userEntity = userService.findByLoginAndPassword(request.getUserName(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUserName());
        return new AuthResponse(token);
    }
}
