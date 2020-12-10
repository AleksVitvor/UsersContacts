package com.aleks._8.DAL.ServiceModels;

import com.aleks._8.DAL.FrontModels.FrontUserForLogging;
import com.sun.istack.internal.Nullable;

public class UserRegistrationVM {
    private String FirstName;
    private String SecondName;
    @Nullable
    private String Patronymic;
    private String PhoneNumber;
    private String UserName;
    private String Password;

    public String getFirstName() {
        return FirstName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
    public UserRegistrationVM(String firstName,
                              String secondName,
                              String password,
                              String phoneNumber,
                              String userName)
    {
        setFirstName(firstName);
        setSecondName(secondName);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setUserName(userName);
    }
    public UserRegistrationVM(String firstName,
                              String secondName,
                              String password,
                              String phoneNumber,
                              String userName,
                              String patronymic)
    {
        setFirstName(firstName);
        setSecondName(secondName);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setUserName(userName);
        setPatronymic(patronymic);
    }

    public static UserRegistrationVM ToRegistrationVM(FrontUserForLogging user)
    {
        return new UserRegistrationVM(
                user.getFirstName(),
                user.getSecondName(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getUserName(),
                user.getPatronymic()
        );
    }
}
