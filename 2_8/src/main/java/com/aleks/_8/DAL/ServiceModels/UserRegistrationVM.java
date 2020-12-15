package com.aleks._8.DAL.ServiceModels;

import com.aleks._8.DAL.FrontModels.FrontUserForLogging;
import com.sun.istack.internal.Nullable;

public class UserRegistrationVM {
    private String UserName;
    private String Password;

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
    public UserRegistrationVM(String password,
                              String userName)
    {
        setPassword(password);
        setUserName(userName);
    }

    public static UserRegistrationVM ToRegistrationVM(FrontUserForLogging user)
    {
        return new UserRegistrationVM(
                user.getPassword(),
                user.getUserName()
        );
    }
}
