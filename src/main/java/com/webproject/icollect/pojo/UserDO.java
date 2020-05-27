package com.webproject.icollect.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(value = { "password"})
public class UserDO {
    private int id;
    private String username;
    private String password;
    private int role = 1;
    private String avatar = "default.png";


    public UserDO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDO(int id, String username, String password, int role, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", avatar='" + avatar + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
