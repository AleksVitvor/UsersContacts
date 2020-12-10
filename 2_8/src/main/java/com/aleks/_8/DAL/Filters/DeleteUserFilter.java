package com.aleks._8.DAL.Filters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteUserFilter {
    private Long UserID;

    public Long getUserID() {
        return UserID;
    }
}
