package com.nick.springbootdemo.web;

import com.nick.springbootdemo.domain.User;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUsername("Nick");
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
        user.setUsername(name);
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

    @RequestMapping("/booking")
    public String requestBooking() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String params = "{\n" +
                "  \"api_key\": \"4A2D1BE1-DF26-4B29-990C-85C751BE1260\",\n" +
                "  \"secret_key\": \"90d9d4d2e1844aaad1114da62f42b9c46ac9720b831c517f641175d81cc8287b\"\n" +
                "}";
        HttpEntity<String> requestEntity = new HttpEntity(params, httpHeaders);
        String res = restTemplate.postForObject("http://13.230.241.58:8189/rest/gateio/getBalance", requestEntity, String.class);
        return res;
    }
}
