package com.aleks._8.DAL.Models;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @Column(name = "CONTACT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(name = "CONTACT_PHONE")
    private String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Column(name = "CONTACT_NAME")
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(name = "CONTACT_SURNAME")
    @Nullable
    private String Surname;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Column(name = "USER_ID")
    private int User_Id;

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public Contact(
            String name,
            String surname,
            String phoneNumber) {
        this.Name=name;
        this.Surname=surname;
        this.PhoneNumber = phoneNumber;
    }

    public Contact() {

    }
}
