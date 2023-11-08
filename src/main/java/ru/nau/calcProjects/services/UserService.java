package ru.nau.calcProjects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.nau.calcProjects.models.Role;
import ru.nau.calcProjects.models.User;
import ru.nau.calcProjects.repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Service
public class UserService implements UserDetailsService {

    private final UserRepository  userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this. userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User serviceUser = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(serviceUser.getUsername(), serviceUser.getPassword(), mapRolesToAthorities(serviceUser.getRoles()));
    }

    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }

    public void addUser(User user) throws Exception {
        User userFormDb = userRepository.findByUsername(user.getUsername());
        if (userFormDb != null) {
            throw new Exception("User exist!");
        }
        userFormDb.setRoles(Collections.singleton(Role.USER));
        userRepository.save(userFormDb);
    }

}
