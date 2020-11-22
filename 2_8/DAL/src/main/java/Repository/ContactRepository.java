package Repository;

import Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findContactByUserId(int userId);
    List<Contact> getContactsByUserId(int userId);
}
