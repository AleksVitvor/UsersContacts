package BLL;

import Models.Contact;
import Models.User;
import ViewModels.UserVM;

public class LoginService {
    public void Register(UserVM userInfo)
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
