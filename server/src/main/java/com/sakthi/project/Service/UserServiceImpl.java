package com.sakthi.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakthi.project.model.User;
import com.sakthi.project.repository.UserRepository;

import java.util.List;

@Service  // This tells Spring to treat this class as a service bean
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor injection for UserRepository
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Fetch all users from DB
    }

    @Override
    public User getUserByCode(Long code) {
        return userRepository.findById(code).orElse(null);  // Find by code (ID)
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);  // Save new user to DB
    }

    @Override
    public User updateUser(Long code, User userDetails) {
        User user = userRepository.findById(code).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long code) {
        userRepository.deleteById(code);  // Delete user by code
    }
}
