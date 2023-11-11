package ru.nau.calcProjects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.nau.calcProjects.models.Role;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.repositories.UserRepository;
import ru.nau.calcProjects.security.CustomUserDetails;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository  userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this. userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User serviceUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(serviceUser);
    }

    public void addUser(User user) throws Exception {
        Optional<User> userFormDb = userRepository.findByUsername(user.getUsername());
        if (userFormDb.isPresent())
            throw new Exception("User exist!");
        user.setRole(Role.USER);
        userRepository.save(user);
    }

}
