package com.aleks._8.DAL.Repository;

import com.aleks._8.DAL.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {
}
