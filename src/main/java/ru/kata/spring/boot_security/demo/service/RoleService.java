package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

@Service
public interface RoleService {
    Role getRole(String name);

    Role getRole(Long id);

    void addRole(Role role);

    Set<Role> getAllRoles();
}
