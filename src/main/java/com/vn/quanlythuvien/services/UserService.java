package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.repositories.UserRepository;
import com.vn.quanlythuvien.requests.user.UserRequest;
import com.vn.quanlythuvien.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequest request) {
        setUpUser(new User(), request);
    }

    @Override
    public void updateUser(int id, UserRequest request) {
        User user = userRepository.findById(id).orElse(null);
        setUpUser(user, request);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    private void setUpUser(User user, UserRequest request) {
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        userRepository.save(user);
    }
}
