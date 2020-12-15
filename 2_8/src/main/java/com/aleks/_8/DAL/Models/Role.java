package com.aleks._8.DAL.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Column(name = "ROLE_NAME")
    private String Role;

    public Role()
    { }
}
