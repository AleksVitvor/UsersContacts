package com.aleks._8.DAL.Filters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteUserFilter {
    private int UserID;

    public int getUserID() {
        return UserID;
    }
}
