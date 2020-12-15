package com.aleks._8.BLL.Services;

import com.aleks._8.DAL.Models.Contact;
import com.aleks._8.DAL.Models.User;
import com.aleks._8.DAL.Repository.ContactRepository;
import com.aleks._8.DAL.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

class UserServiceTest {

    UserRepository userRepository;
    ContactRepository contactRepository;
    Set<User> users=new HashSet<User>();
    Set<Contact> contacts=new HashSet<Contact>();

    @BeforeEach
    void Generate()
    {
        userRepository=Mockito.mock(UserRepository.class);
        contactRepository=Mockito.mock(ContactRepository.class);
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        Contact contact3 = new Contact();
        User user=new User();
        Set<Contact> contacts=new HashSet<Contact>();
        contact1.setId(1);
        contact2.setId(2);
        contact3.setId(3);
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        user.setContactSet(contacts);
        user.setUsername("test");
        users.add(user);
        this.contacts.addAll(contacts);

    }

    @Test
    void getUserByUsername() throws Exception {
        Mockito.when(userRepository.findByUserName("test")).
                thenReturn(users.stream().filter(u -> u.getUsername().equalsIgnoreCase("test")).
                        findFirst().get());
        User user=userRepository.findByUserName("test");
        if(!user.getUsername().equalsIgnoreCase("test"))
            throw new Exception("Not work");
    }

    @Test
    void addContact() throws Exception {
        Mockito.when(userRepository.findByUserName("test")).
                thenReturn(users.stream().filter(u -> u.getUsername().equalsIgnoreCase("test")).
                        findFirst().get());
        Contact contact4=new Contact();
        contact4.setId(4);
        User user=userRepository.findByUserName("test");
        Set<Contact> contacts=user.getContactSet();
        contacts.add(contact4);
        user.setContactSet(contacts);
        users.clear();
        users.add(user);
        User user1=userRepository.findByUserName("test");
        if(user1.getContactSet().size()!=4)
            throw new Exception("Not work");
    }
}