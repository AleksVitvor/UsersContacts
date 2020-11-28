package com.aleks._8.DAL.FrontModels;

import com.aleks._8.DAL.Models.User;

public class UserNameOnly {
    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
    public UserNameOnly(String UserName)
    {
        this.UserName= UserName;
    }
}
