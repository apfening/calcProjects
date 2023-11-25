package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nau.calcProjects.exception.UserExistException;
import ru.nau.calcProjects.exception.ValidateException;
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
    
    @PostMapping("/api/user")
    public User createPrice(@RequestBody User user) throws UserExistException, ValidateException {
        if (user.getUsername().isEmpty()) {
            throw new ValidateException("Имя пользователя не может быть пустым. Необходимо заполнить.");
        } else if (user.getPassword().isEmpty()) {
            throw new ValidateException("Пароль не может быть пустым. Необходимо заполнить.");
        }
        return userService.addUser(user);
    }

//    @PutMapping("/api/user/{id}")
//    public User editPrice(@PathVariable("id") long id, @RequestBody User user) throws UserNotFoundException {
//        if (user.getTitle().isEmpty()) {
//            throw new RuntimeException("Название прайса не может быть пустым. Необходимо заполнить.");
//        }
//        return userService.editUser(user, id);
//    }

    @DeleteMapping("/api/user/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "{\"state\":\"success\"}";
    }
}
