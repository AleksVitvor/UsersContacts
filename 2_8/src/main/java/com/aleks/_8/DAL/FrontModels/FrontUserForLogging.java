package com.aleks._8.DAL.FrontModels;

import com.aleks._8.DAL.ServiceModels.UserRegistrationVM;
import com.google.common.hash.Hashing;
import com.sun.istack.internal.Nullable;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

public class FrontUserForLogging {
    private String FirstName;
    private String SecondName;
    @Nullable
    private String Patronymic;
    private String PhoneNumber;
    private String UserName;
    private String Password;
    public UserRegistrationVM toUserRegistration()
    {
        if(Patronymic.isEmpty())
        {
            return new UserRegistrationVM(FirstName,
                    SecondName,
                    DigestUtils.sha256Hex(Password),
                    PhoneNumber,
                    UserName);
        }
        return new UserRegistrationVM(FirstName,
                SecondName,
                DigestUtils.sha256Hex(Password),
                PhoneNumber,
                UserName,
                Patronymic);
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Hashing.sha256()
                .hashString(Password, StandardCharsets.UTF_8)
                .toString();
    }

    public void setPassword(String password) {
        Password = password;
    }
}
