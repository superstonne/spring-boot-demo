package com.nick.springbootdemo.domain;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty(message = "姓名不能为空")
    @Column(nullable = false, unique = true)
    private String username;

    @Max(value = 100, message = "Age shouldn't be bigger than 100")
    @Min(value = 18, message = "Age should be bigger than 18")
    @Column
    private int age;

    @NotEmpty(message = "Password shouldn't be empty")
    @Length(min = 6, message = "Password should be more than 6")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String nickName;

    @Column(nullable = false)
    private String regTime;

    public User() {
    }

    public User(String name, int age, String password) {
        this.username = name;
        this.age = age;
        this.password = password;
    }

    public User(@NotEmpty(message = "姓名不能为空") String username,
                @Max(value = 100, message = "Age shouldn't be bigger than 100")
                @Min(value = 18, message = "Age should be bigger than 18") int age,
                @NotEmpty(message = "Password shouldn't be empty")
                @Length(min = 6, message = "Password should be more than 6") String password,
                String email, String nickName, String regTime) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}
