package com.nick.springbootdemo;

import com.nick.springbootdemo.domain.UserDetail;
import com.nick.springbootdemo.repository.UserDetailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailRepositoryTests {


    @Autowired
    UserDetailRepository userDetailRepository;

    @Test
    public void testSaveUserDetail() {
        UserDetail userDetail = new UserDetail("1", "紫薇路", "打篮球");
        userDetailRepository.save(userDetail);

    }

    @Test
    public void testGetUserDetail() {
        List<UserInfo> userInfoList = (List<UserInfo>) userDetailRepository.findUserInfo("打篮球");

        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo.getUserName() + "-" + userInfo.getHobby());
        }
    }

}
