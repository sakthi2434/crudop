package com.sakthi.project.Service;

import com.sakthi.project.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserByCode(Long code);
    User createUser(User user);
    User updateUser(Long code, User user);
    void deleteUser(Long code);
}