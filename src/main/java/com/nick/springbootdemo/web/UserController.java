package com.nick.springbootdemo.web;

import com.nick.springbootdemo.domain.User;
import com.nick.springbootdemo.param.UserParam;
import com.nick.springbootdemo.repository.repo1.UserRepository1;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository1 userRepository;

    @RequestMapping("")
    public String add() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(@Valid UserParam userParam, BindingResult result, ModelMap modelMap) {
        String errorMessage = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMessage += error.getCode() + "-" + error.getDefaultMessage();
            }
            modelMap.addAttribute("errorMessage", errorMessage);
            return "user/userAdd";
        }
        User u = userRepository.findByUsername(userParam.getUsername());
        if (u != null) {
            modelMap.addAttribute("errorMessage", "User name has already existed.");
            return "user/userAdd";
        }

        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        user.setRegTime(new Date().toString());
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "2") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> users = userRepository.findList(pageable);
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(@Valid UserParam userParam, BindingResult result, ModelMap map) {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg += error.getCode() + "-" + error.getDefaultMessage();
            }
            map.addAttribute("errorMsg", errorMsg);
            map.addAttribute("user", userParam);
            return "user/userEdit";
        }
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        user.setRegTime(new Date().toString());
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(long id) {
        userRepository.delete(id);
        return "redirect:/user/list";
    }
}
