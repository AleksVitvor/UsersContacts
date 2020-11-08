package Repository;

import Models.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    Contact getContactByUserId(int userId);
    List<Contact> getAllUserContacts(int userId);
}
