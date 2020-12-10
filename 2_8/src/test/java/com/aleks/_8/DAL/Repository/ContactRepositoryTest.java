package com.aleks._8.DAL.Repository;

import com.aleks._8.DAL.Models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {
    Set<Contact> contactSet=new HashSet<Contact>();
    @BeforeEach
    void setUp() {
        Contact contact1=new Contact();
        contact1.setSurname("LAL");
        contact1.setName("LOL");
        contact1.setUser_Id(1);
        contact1.setId(1);
        contact1.setPhoneNumber("+375447801241");
        Contact contact2=new Contact();
        contact2.setSurname("LAL");
        contact2.setName("LOL");
        contact2.setUser_Id(1);
        contact2.setId(2);
        contact2.setPhoneNumber("+375447801242");
        Contact contact3=new Contact();
        contact3.setSurname("LAL");
        contact3.setName("LOL");
        contact3.setUser_Id(2);
        contact3.setId(3);
        contact3.setPhoneNumber("+375447801243");
        contactSet.add(contact1);
        contactSet.add(contact2);
        contactSet.add(contact3);
    }

    @Test
   void findById() throws Exception {
        int Id= 1;
        Contact contact=contactSet.parallelStream().filter(u->u.getId()==Id).findFirst().get();
        if(!contact.getPhoneNumber().equalsIgnoreCase("+375447801241"))
            throw new Exception("Not found");
    }
}