package com.nick.springbootdemo.web;

import com.nick.springbootdemo.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("Nick");
        user.setAge(18);
        user.setPassword("123456");
        return user;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("金龙桑", 18, "2342312"));
        users.add(new User("雪儿", 18, "21312312"));
        return users;
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public User get(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
