package Repository;

import Models.Contact;
import Models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {
    Contact findContactByUserId(int userId);
    List<Contact> findContactsByUserId(int userId, Pageable pageable);
    List<Contact> findContactsByUserSetNotContains(User user, Pageable pageable);
    Contact findById(int contactId);
}
