package com.aleks._8.BLL.Services;

import com.aleks._8.DAL.FrontModels.UserNameOnly;
import com.aleks._8.DAL.Models.Contact;
import com.aleks._8.DAL.Models.User;
import com.aleks._8.DAL.Repository.ContactRepository;
import com.aleks._8.DAL.Repository.RolesRepository;
import com.aleks._8.DAL.Repository.UserRepository;
import com.aleks._8.DAL.ServiceModels.UserRegistrationVM;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class LoginService {
    private UserRepository userRepository;
    private ContactRepository contactRepository;
    private RolesRepository rolesRepository;
    @Autowired
    public LoginService(UserRepository userRepository,
                        ContactRepository contactRepository,
                        RolesRepository rolesRepository)
    {
        this.userRepository=userRepository;
        this.contactRepository=contactRepository;
        this.rolesRepository=rolesRepository;
    }
    public void Register(UserRegistrationVM userInfo)
    {
        User user=new User(userInfo.getFirstName(),
                userInfo.getSecondName(),
                userInfo.getPatronymic(),
                userInfo.getUserName(),
                userInfo.getPassword());
        Contact contact=new Contact(userInfo.getPhoneNumber(),
                user);
        userRepository.save(user);
        contactRepository.save(contact);
    }
    public int Login(String userName, String password)
    {
        password=Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        if(userRepository.findByUserName(userName).getPassword()==password)
        {
            return userRepository.findByUserNameAndPassword(userName, password).getId();
        }
        return -1;
    }
    public void Save(User user)
    {
        userRepository.save(user);
    }
    public UserNameOnly findByLoginAndPassword(String UserName, String Password)
    {
        if(userRepository.findByUserName(UserName).getPassword()==Password)
        {
            return new UserNameOnly(userRepository.findByUserNameAndPassword(UserName, Password).getUserName());
        }
        return null;
    }
}

