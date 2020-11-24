package Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String PhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "userscontacts",
            joinColumns = @JoinColumn(name = "Contact_Id"),
            inverseJoinColumns = @JoinColumn(name = "User_Id")
    )
    private Set<User> userSet;

    public Contact(String phoneNumber, User user) {
        this.PhoneNumber = phoneNumber;
        this.user = user;
    }

    public Contact() {

    }
}
