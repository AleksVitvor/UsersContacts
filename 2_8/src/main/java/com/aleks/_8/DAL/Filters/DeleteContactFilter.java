package com.aleks._8.DAL.Filters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteContactFilter {
    private String token;

    public String getToken() {
        return token;
    }

    private int ContactId;

    public int getContactId() {
        return ContactId;
    }
}
