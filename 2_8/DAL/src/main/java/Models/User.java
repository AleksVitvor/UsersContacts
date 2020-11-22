package Models;

import com.google.common.hash.Hashing;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public Contact getUserContact() {
        return UserContact;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public int getRole_Id() {
        return Role_Id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public void setUserContact(Contact userContact) {
        UserContact = userContact;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public void setRole_Id(int role_Id) {
        Role_Id = role_Id;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "FirstName")
    private String FirstName;
    @Column(name="SecondName")
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
    private Set<Contact> contactSet;
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

    public User() {

    }

    public String getSecondName() {
        return SecondName;
    }
}
