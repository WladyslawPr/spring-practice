package com.example.spring_practice.config.login;


public class LoginCredentials {
    private String name;
    private String password;

    public LoginCredentials (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName () {
        return name;
    }

    public String getPassword () {
        return password;
    }

}
