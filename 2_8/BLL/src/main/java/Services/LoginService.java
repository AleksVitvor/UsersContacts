package Services;

import Models.Contact;
import Models.Role;
import Models.User;
import Repository.ContactRepository;
import Repository.RolesRepository;
import Repository.UserRepository;
import ServiceModels.UserRegistrationVM;
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
        Role role=rolesRepository.findByRole("ROLE_USER");
        User user=new User(userInfo.getFirstName(),
                userInfo.getSecondName(),
                userInfo.getPatronymic(),
                userInfo.getUserName(),
                userInfo.getPassword());
        user.setRole_Id(role.getId());
        Contact contact=new Contact(userInfo.getPhoneNumber(),
                user);
        userRepository.save(user);
        contactRepository.save(contact);
    }
    public int Login(String userName, String password)
    {
        password=Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        if(userRepository.existsByUserNameAndPassword(userName, password))
        {
            return userRepository.findByUserNameAndPassword(userName, password).getId();
        }
        return -1;
    }
}
