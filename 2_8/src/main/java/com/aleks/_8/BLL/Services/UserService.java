package com.aleks._8.BLL.Services;

import com.aleks._8.DAL.Models.Contact;
import com.aleks._8.DAL.Models.User;
import com.aleks._8.DAL.Repository.ContactRepository;
import com.aleks._8.DAL.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContactRepository contactRepository;

    public User getUserByUsername(String Username)
    {
        return userRepository.findByUserName(Username);
    }
    public void deleteContactFromUsersContacts(String Username,
                                               Long ContactId)
    {
        User user=userRepository.findByUserName(Username);
        Set<Contact> contactSet=user.getContactSet();
        Contact contact=contactRepository.findById(ContactId).get();
        contactSet.remove(contact);
        user.setContactSet(contactSet);
        userRepository.save(user);
    }

    public void addContact(String Username,
                           Contact contact)
    {
        User user=userRepository.findByUserName(Username);
        contact.setUser_Id(user.getId());
        Set<Contact> contacts = user.getContactSet();
        contacts.add(contact);
        user.setContactSet(contacts);
        userRepository.save(user);
    }
    public void deleteUser(Long Id)
    {
        userRepository.deleteById(Id);
    }
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
}
