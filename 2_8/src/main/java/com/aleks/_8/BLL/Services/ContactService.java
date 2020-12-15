package com.aleks._8.BLL.Services;

import com.aleks._8.DAL.Models.Contact;
import com.aleks._8.DAL.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public void UpdateContact(int Id, @org.jetbrains.annotations.NotNull Contact newContact)
    {
        Contact old = contactRepository.findById(Id).get();
        old.setName(newContact.getName());
        old.setSurname(newContact.getSurname());
        contactRepository.save(old);
    }
}

