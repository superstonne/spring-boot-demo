package com.nick.springbootdemo.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Max(value = 100, message = "Age shouldn't be bigger than 100")
    @Min(value = 18, message = "Age should be bigger than 18")
    private int age;

    @NotEmpty(message = "Password shouldn't be empty")
    @Length(min = 6, message = "Password should be more than 6")
    private String password;

    public User() {
    }

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
