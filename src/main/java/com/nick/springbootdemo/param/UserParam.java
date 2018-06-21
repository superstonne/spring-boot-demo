package com.nick.springbootdemo.param;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class UserParam {

    private long id;

    @NotEmpty(message = "Name shouldn't be empty")
    private String username;

    @NotEmpty(message = "Password shouldn't be empty")
    @Length(min = 6, message = "Password length shouldn't be less than 6")
    private String password;

    @Max(value = 100, message = "Age should be less than 100")
    @Min(value = 18, message = "Age should be bigger than 18")
    private int age;

    @NotEmpty(message = "Email address can't be empty")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
