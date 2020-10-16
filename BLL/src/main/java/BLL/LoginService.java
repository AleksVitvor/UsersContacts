package BLL;

import Models.Contact;
import Models.User;
import ViewModels.UserRegistrationVM;

public class LoginService {
    public void Register(UserRegistrationVM userInfo)
    {
        User user=new User(userInfo.getFirstName(),
                userInfo.getSecondName(),
                userInfo.getPatronymic(),
                userInfo.getUserName(),
                userInfo.getPassword());
        Contact contact=new Contact(userInfo.getPhoneNumber(),
                user);
    }
}
