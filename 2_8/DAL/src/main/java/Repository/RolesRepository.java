package Repository;

import Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepository extends JpaRepository<Role, Integer> {
    List<Role> findAll();
    Role findByRole(String roleType);
}
