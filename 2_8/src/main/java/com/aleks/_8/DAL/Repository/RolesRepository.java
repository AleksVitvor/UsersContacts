package com.aleks._8.DAL.Repository;

import com.aleks._8.DAL.Models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
    Optional<Role> findById(Long Id);
}
