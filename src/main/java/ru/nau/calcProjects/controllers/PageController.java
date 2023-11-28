package ru.nau.calcProjects.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.services.UserServiceImpl;

@Controller
public class PageController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public PageController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/admin/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin/addUser")
    public String addUserPage() {
        return "addUser";
    }

    @GetMapping ("/admin/user/{id}")
    public String editUser(Model model, @PathVariable("id") long userId) {
        model.addAttribute("id", userId);
        return "editUser";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPage(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            return  "registration";
        }
        userServiceImpl.addUser(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin/price")
    public String pricePage() {
        return "price";
    }

    @GetMapping("/admin/addPrice")
    public String addPricePage() {
        return "addPrice";
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client";
    }

    @GetMapping ("/client/{id}")
    public String editPage(Model model, @PathVariable("id") long clientId) {
        model.addAttribute("id", clientId);
        return "editClient";
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

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/admin/adminCalculation")
    public String adminCalculationPage() {
        return "adminCalculation";
    }

    @GetMapping("/forbidden")
    public String forbiddenPage() {
        return "forbidden";
    }
}
