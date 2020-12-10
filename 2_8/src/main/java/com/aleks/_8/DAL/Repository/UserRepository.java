package com.aleks._8.DAL.Repository;

import com.aleks._8.DAL.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    @Query(value = "Select u FROM User u where u.Username=:Username AND u.Password=:Password")
    User findByUserNameAndPassword(@Param("Username")String userName,
                                   @Param("Password") String password);
    @Query(value = "Select u From User u where u.Username=:Username")
    User findByUserName(@Param("Username") String userName);
}
