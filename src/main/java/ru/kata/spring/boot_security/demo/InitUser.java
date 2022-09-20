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
        roleService.addRole(roleAdmin);
        Role roleUser = new Role("ROLE_USER");
        roleService.addRole(roleUser);

        User user = new User("user@mail.ru", "user", "user", "user", 30);
        user.getRoles().add(roleService.getRole(2L));
        User admin = new User("admin@mail.ru", "admin", "admin", "admin", 35);
        admin.getRoles().add(roleService.getRole(1L));
        admin.getRoles().add(roleService.getRole(2L));
        userService.addUser(admin);
        userService.addUser(user);
    }
}