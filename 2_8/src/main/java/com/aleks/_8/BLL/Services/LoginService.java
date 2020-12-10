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
    @Autowired
    public LoginService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public void Register(UserRegistrationVM userInfo)
    {
        User user=new User(
                userInfo.getUserName(),
                userInfo.getPassword());
        userRepository.save(user);
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
            return new UserNameOnly(userRepository.findByUserNameAndPassword(UserName, Password).getUsername());
        }
        return null;
    }
}

