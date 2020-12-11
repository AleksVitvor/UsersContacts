package com.aleks._8.DAL.FrontModels;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class FrontUserForLogging {
    private String UserName;
    private String Password;

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Hashing.sha256()
                .hashString(Password, StandardCharsets.UTF_8)
                .toString();
    }
}
