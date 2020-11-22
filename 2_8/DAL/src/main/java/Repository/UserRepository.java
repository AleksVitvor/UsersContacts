package Repository;

import Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User getById(int id);
    User findByUserNameAndAndPassword(String userName, String password);
    boolean existsByUserNameAndPassword(String userName, String password);
}
