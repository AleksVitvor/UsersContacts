package com.aleks._8.BLL.Services;

import com.aleks._8.DAL.Models.Contact;
import com.aleks._8.DAL.Models.User;
import com.aleks._8.DAL.Repository.ContactRepository;
import com.aleks._8.DAL.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ContactService {
    private ContactRepository contactRepository;
    private UserRepository userRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository,
                          UserRepository userRepository)
    {
        this.contactRepository=contactRepository;
        this.userRepository=userRepository;
    }
    public void AddContact(int contactId, int userId)
    {
        User user=userRepository.findById((long) userId).get();
        Contact contact=contactRepository.findById((long) contactId).get();
        Set<Contact> contacts=user.getContactSet();
        contacts.add(contact);
        user.setContactSet(contacts);
    }
    public void RemoveContact(int contactId, int userId)
    {
        User user=userRepository.findById((long) userId).get();
        Contact contact=contactRepository.findById((long) contactId).get();
        Set<Contact> contacts=user.getContactSet();
        contacts.remove(contact);
        user.setContactSet(contacts);
    }
}

