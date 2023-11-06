package com.example.CrudProject.Entity;

public class UserLoginRequest {
    String username;
    String password;
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username=username;

    }
    public void setPassword(String password) {
        this.password=password;
    }

}
