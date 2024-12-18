package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.requests.user.UserRequest;

public interface IUserService {
    void createUser(UserRequest request);

    void updateUser(int id, UserRequest request);

    void deleteUser(int id);

    List<User> searchUser(String keyword);

    User findByUsernameAndPassword(String username, String password);
}
