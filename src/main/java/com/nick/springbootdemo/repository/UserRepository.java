package com.nick.springbootdemo.repository;

import com.nick.springbootdemo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameOrEmail(String username, String email);

    @Query("select u from User u")
    Page<User> findAll(Pageable pageable);

    Page<User> findByNickName(String nickName, Pageable pageable);
}
