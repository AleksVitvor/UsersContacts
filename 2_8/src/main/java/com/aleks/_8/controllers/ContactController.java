package com.aleks._8.controllers;

import com.aleks._8.BLL.Services.ContactService;
import com.aleks._8.BLL.Services.UserService;
import com.aleks._8.DAL.Filters.AddContactFilter;
import com.aleks._8.DAL.Filters.AllContactsFilter;
import com.aleks._8.DAL.Filters.DeleteContactFilter;
import com.aleks._8.DAL.Filters.UpdateContactFilter;
import com.aleks._8.DAL.Models.Contact;
import com.aleks._8.DAL.Models.User;
import com.aleks._8.config.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping(path = "/user/contacts")
    public Set<Contact> getAllUsersContacts(AllContactsFilter filter)
    {
        String Login=jwtProvider.getLoginFromToken(filter.getToken());
        User user = userService.getUserByUsername(Login);
        return user.getContactSet();
    }

    @DeleteMapping(path = "/user/delete_contact")
    public void deleteContactFromUsersContacts(DeleteContactFilter deleteFilter)
    {
        userService.deleteContactFromUsersContacts(
                jwtProvider.getLoginFromToken(deleteFilter.getToken()),
                deleteFilter.getContactId()
        );
    }
    @PutMapping(path = "/user/add_contact")
    public void addContact(AddContactFilter filter)
    {
        userService.addContact(
                jwtProvider.getLoginFromToken(filter.getToken()),
                new Contact(filter.getContactName(),
                        filter.getContactSurname(),
                        filter.getContactPhoneNumber())
        );
    }

    @PostMapping(path = "/user/update_contact")
    public void updateContact(UpdateContactFilter updateContactFilter)
    {
        contactService.UpdateContact(updateContactFilter.getContactId(),
                new Contact(updateContactFilter.getContactName(),
                        updateContactFilter.getContactSurname(),
                        updateContactFilter.getContactPhoneNumber()));
    }
}