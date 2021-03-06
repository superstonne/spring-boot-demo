package com.nick.springbootdemo;

import com.nick.springbootdemo.domain.User;
import com.nick.springbootdemo.repository.repo1.UserRepository1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

import static java.text.DateFormat.LONG;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Resource
    private UserRepository1 userRepository;

    @Test
    public void test() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(LONG, LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("金龙", 18, "123456", "51512226441@qq.com", "Nick", formattedDate));
//        userRepository.save(new User("雪儿", 18, "123456", "28553075831@qq.com", "Shirley", formattedDate));

        Assert.assertEquals(2, userRepository.findAll().size());
        Assert.assertEquals(1, userRepository.findByUsernameOrEmail("金龙", "515122644@qq.com").getId());
    }

    @Test
    public void testGet() {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findByUsername("金龙"));
        System.out.println(userRepository.count());
    }

    @Test
    public void testPageQuery() {
        int page = 1;
        int size = 1;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);

        Page<User> res = userRepository.findAll(pageable);
        Iterator<User> iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
