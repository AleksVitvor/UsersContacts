package FrontModels;

import ServiceModels.UserRegistrationVM;
import com.sun.istack.internal.Nullable;
import org.apache.commons.codec.digest.DigestUtils;

public class FrontUserForLogging {
    private String FirstName;
    private String SecondName;
    @Nullable
    private String Patronymic;
    private String PhoneNumber;
    private String UserName;
    private String Password;
    public UserRegistrationVM toUserRegistration()
    {
        if(Patronymic.isEmpty())
        {
            return new UserRegistrationVM(FirstName,
                    SecondName,
                    DigestUtils.sha256Hex(Password),
                    PhoneNumber,
                    UserName);
        }
        return new UserRegistrationVM(FirstName,
                SecondName,
                DigestUtils.sha256Hex(Password),
                PhoneNumber,
                UserName,
                Patronymic);
    }
}
