package com.aleks._8.DAL.Repository;

import com.aleks._8.DAL.Models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    Optional<Contact> findById(Long contactId);
}
