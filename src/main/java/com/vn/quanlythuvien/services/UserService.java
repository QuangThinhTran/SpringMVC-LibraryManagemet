package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Role;
import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.repositories.RoleRepository;
import com.vn.quanlythuvien.repositories.UserRepository;
import com.vn.quanlythuvien.requests.user.CustomerRequest;
import com.vn.quanlythuvien.requests.user.UserRequest;
import com.vn.quanlythuvien.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(CustomerRequest request) {
        setUpUser(new User(), request);
    }

    @Override
    public void updateUser(int id, CustomerRequest request) {
        User user = userRepository.findById(id);
        setUpUser(user, request);
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> searchUser(String keyword) {
        return userRepository.searchUser(keyword);
    }

    @Override
    public List<User> getUserByRole(String role) {
        Role roleEntity = roleRepository.findByName(role);
        return userRepository.getUserByRole(roleEntity);
    }

    private void setUpUser(User user, CustomerRequest request) {
        Role role = roleRepository.findByName("user");
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRole(role);
        userRepository.save(user);
    }
}
