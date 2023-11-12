package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPage(User user) throws Exception {
        userService.addUser(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
