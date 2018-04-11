package Entities;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Named
public class Account implements Serializable {

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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> followers;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> follwing;

    private String biography;

    private String location;

    private Date lastLogin;

    private UserRole role;


    public Account(){
        //Beautiful empty constructor for JPA
    }

    public Account(String name, String password, String mail){
        passwordHash = password;
        username = name;
        email = mail;
    }

    public Account(String name, String password, String mail, int userid){
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

    public List<Account> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Account> followers) {
        this.followers = followers;
    }

    public List<Account> getFollwing() {
        return follwing;
    }

    public void setFollwing(List<Account> follwing) {
        this.follwing = follwing;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
