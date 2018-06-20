package com.nick.springbootdemo;

import com.nick.springbootdemo.domain.User;
import com.nick.springbootdemo.repository.repo1.UserRepository1;
import com.nick.springbootdemo.repository.repo2.UserRepository2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultipleDataSourceTests {

    @Resource
    private UserRepository1 userRepository;

    @Resource
    private UserRepository2 userRepository2;

    @Test
    public void save() {
        User user = new User("尼克", 18, "123456", "515122644@mini.com", "笨笨", "2018-06-20");
        userRepository.save(user);

        userRepository2.save(user);

    }
}
