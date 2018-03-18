package entities;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Named
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(name = "password")
    private String passwordHash;

    @Column(unique = true)
    @Email
    private String email;

    public User(){
        //Beautiful empty constructor for JPA
    }

    public User(String name, String password, String mail){
        passwordHash = password;
        username = name;
        email = mail;
    }

    public User(String name, String password, String mail, int userid){
        passwordHash = password;
        username = name;
        email = mail;
        id = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
