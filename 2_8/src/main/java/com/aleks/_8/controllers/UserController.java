package com.aleks._8.controllers;

import com.aleks._8.BLL.Services.UserService;
import com.aleks._8.DAL.Filters.DeleteUserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @DeleteMapping(path = "/admin/delete")
    public void deleteUser(DeleteUserFilter deleteUserFilter)
    {
        userService.deleteUser(deleteUserFilter.getUserID());
    }
}
