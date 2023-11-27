package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nau.calcProjects.exception.UserExistException;
import ru.nau.calcProjects.exception.UserNotFoundException;
import ru.nau.calcProjects.exception.ValidateException;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.services.UserServiceImpl;

import java.util.List;

@RestController
public class UserRestController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserRestController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/api/user")
    List<User> getAllUser() {
        return userServiceImpl.findAllUser();
    }
    
    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) throws UserExistException, ValidateException {
        if (user.getUsername().isEmpty()) {
            throw new ValidateException("Имя пользователя не может быть пустым. Необходимо заполнить.");
        } else if (user.getPassword().isEmpty()) {
            throw new ValidateException("Пароль не может быть пустым. Необходимо заполнить.");
        }
        User returnUser = userServiceImpl.addUser(user);
        returnUser.setPassword("hidden");
        return returnUser;
    }

    @PutMapping("/api/user/{id}")
    public User editUser(@PathVariable("id") long id, @RequestBody User user) throws UserNotFoundException {
        User returnUser = userServiceImpl.editUser(user, id);
        returnUser.setPassword("hidden");
        return returnUser;
    }

    @DeleteMapping("/api/user/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        userServiceImpl.deleteById(id);
        return "{\"state\":\"success\"}";
    }
}
