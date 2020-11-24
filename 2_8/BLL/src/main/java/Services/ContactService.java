package Services;

import Models.Contact;
import Models.User;
import Repository.ContactRepository;
import Repository.UserRepository;
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
        User user=userRepository.getById(userId);
        Contact contact=contactRepository.findById(contactId);
        Set<Contact> contacts=user.getContactSet();
        contacts.add(contact);
        user.setContactSet(contacts);
    }
    public void RemoveContact(int contactId, int userId)
    {
        User user=userRepository.getById(userId);
        Contact contact=contactRepository.findById(contactId);
        Set<Contact> contacts=user.getContactSet();
        contacts.remove(contact);
        user.setContactSet(contacts);
    }
}
