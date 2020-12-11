package com.aleks._8.BLL.Validation;

import com.aleks._8.DAL.Filters.AddContactFilter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactValidator {
    public boolean IsValid(AddContactFilter contact)
    {
        if(contact.getContactName().isEmpty())
            return false;
        if(contact.getContactSurname().isEmpty())
            return false;
        if(IsValidPhoneNumber(contact.getContactPhoneNumber()))
            return false;
        return true;
    }
    private boolean IsValidPhoneNumber(String phoneNumber)
    {
        if(phoneNumber.isEmpty())
            return false;
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
