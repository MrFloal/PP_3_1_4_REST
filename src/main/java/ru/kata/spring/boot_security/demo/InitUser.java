package ru.kata.spring.boot_security.demo;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class InitUser {

    private final RoleService roleService;
    private final UserService userService;

    public InitUser(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User user = new User("name1", "surname1", "user", "user");
        user.getRoles().add(roleService.getRole("ROLE_USER"));
        userService.addUser(user);
        User admin = new User("name2", "surname2", "admin", "admin");
        admin.getRoles().add(roleService.getRole("ROLE_ADMIN"));
        admin.getRoles().add(roleService.getRole("ROLE_USER"));
        userService.addUser(admin);
    }
}