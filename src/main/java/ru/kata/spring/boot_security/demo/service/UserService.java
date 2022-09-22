package ru.kata.spring.boot_security.demo.service;



import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}