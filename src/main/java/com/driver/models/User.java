package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public User() {

    }

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public User(Integer userId, String userName, String password) {
        this.id = userId;
        this.username = userName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
}