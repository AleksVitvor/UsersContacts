package com.aleks._8.controllers;

import com.aleks._8.BLL.Services.UserService;
import com.aleks._8.DAL.Filters.DeleteUserFilter;
import com.aleks._8.DAL.FrontModels.UserInfo;
import com.aleks._8.DAL.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @DeleteMapping(path = "/admin/delete")
    public void deleteUser(DeleteUserFilter deleteUserFilter)
    {
        userService.deleteUser(deleteUserFilter.getUserID());
    }

    @GetMapping(path = "/admin/all")
    public List<UserInfo> getAllUsers()
    {
        List<UserInfo> users=new ArrayList<UserInfo>();
        List<User> allUsers=userService.getAll();
        for(User u:allUsers)
        {
            UserInfo info=new UserInfo();
            info.setId(u.getId());
            info.setUsername(u.getUsername());
            users.add(info);
        }
        return users;
    }
}
