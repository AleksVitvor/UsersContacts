package Models;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "FirstName")
    private String FirstName;
    private String SecondName;
    @Nullable
    private String Patronymic;

    @OneToOne(mappedBy = "user")
    private Contact UserContact;

    @ManyToMany
    @JoinTable(
            name="userscontacts",
            joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "Contact_Id")
    )
    Set<Contact> contactSet;
    @Column(name="Role_Id")
    private int Role_Id;

    @Column(name = "UserName")
    private String UserName;

    @Column(name = "Password")
    private String Password;


    public User(String firstName, String secondName, String patronymic, String userName, String password) {
        FirstName = firstName;
        SecondName = secondName;
        Patronymic = patronymic;
        UserName = userName;
        Password = password;
    }
}
