package com.aleks._8.DAL.Filters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateContactFilter {
    private String ContactName;

    public String getContactName() {
        return ContactName;
    }

    private String ContactSurname;

    public String getContactSurname() {
        return ContactSurname;
    }

    private String ContactPhoneNumber;

    public String getContactPhoneNumber() {
        return ContactPhoneNumber;
    }

    private int ContactId;

    public int getContactId() {
        return ContactId;
    }
}
