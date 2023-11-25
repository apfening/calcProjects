package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.services.UserService;

@Controller
public class PageController {

    private final UserService userService;

    @Autowired
    public PageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/addUser")
    public String addUserPage() {
        return "addUser";
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

    @GetMapping("/price")
    public String pricePage() {
        return "price";
    }

    @GetMapping("/addPrice")
    public String addPricePage() {
        return "addPrice";
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client";
    }

    @GetMapping("/addClient")
    public String addClientPage() {
        return "addClient";
    }

    @GetMapping("/calculation")
    public String calculationPage() {
        return "calculation";
    }

    @GetMapping("/addCalculation")
    public String addCalculationPage() {
        return "addCalculation";
    }
}
