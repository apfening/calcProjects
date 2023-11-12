package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.services.UserService;

import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    List<User> getAllUser() {
        return userService.findAllUser();
    }

    @DeleteMapping("/api/user/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "{\"state\":\"success\"}";
    }
}
