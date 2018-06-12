package com.nick.springbootdemo.repository;

import com.nick.springbootdemo.UserInfo;
import com.nick.springbootdemo.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    @Query("select u.userName as userName, u.email as email, d.address as address, d.hobby as hobby from User u," +
            " UserDetail d where u.id = d.userId and d.hobby = ?1")
    List<UserInfo> findUserInfo(String hobby);
}
