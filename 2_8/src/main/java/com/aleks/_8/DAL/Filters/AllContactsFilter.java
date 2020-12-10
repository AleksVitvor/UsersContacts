package com.aleks._8.DAL.Filters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AllContactsFilter {
    private String token;

    public String getToken() {
        return token;
    }
}
