package Repository;

import Models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);
    User getById(int id);
    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
    boolean existsByUserNameAndPassword(String userName, String password);
}
