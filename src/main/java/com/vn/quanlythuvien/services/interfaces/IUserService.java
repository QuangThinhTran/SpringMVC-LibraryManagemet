package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.requests.user.CustomerRequest;
import com.vn.quanlythuvien.requests.user.UserRequest;

import java.util.List;

public interface IUserService {
    void createUser(CustomerRequest request);

    void updateUser(int id, CustomerRequest request);

    void deleteUser(int id);

    List<User> searchUser(String keyword);

    User findByUsernameAndPassword(String username, String password);

    List<User> getUserByRole(String role);
}
