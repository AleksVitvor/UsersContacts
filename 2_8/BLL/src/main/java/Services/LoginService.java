package Services;

import Models.Contact;
import Models.User;
import Repository.ContactRepository;
import Repository.UserRepository;
import ServiceModels.UserRegistrationVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepository userRepository;
    private ContactRepository contactRepository;
    @Autowired
    public LoginService(UserRepository userRepository, ContactRepository contactRepository)
    {
        this.userRepository=userRepository;
        this.contactRepository=contactRepository;
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
}
