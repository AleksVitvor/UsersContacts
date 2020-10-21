package ViewModels;

import com.sun.istack.internal.Nullable;

public class UserRegistrationVM {
    private String FirstName;
    private String SecondName;
    @Nullable
    private String Patronymic;
    private String PhoneNumber;
    private String UserName;
    private String Password;

    public String getFirstName() {
        return FirstName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getUserName() {
        return UserName;
    }


}
