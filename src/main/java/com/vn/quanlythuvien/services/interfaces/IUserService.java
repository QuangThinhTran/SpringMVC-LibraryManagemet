package com.vn.quanlythuvien.services.interfaces;

public interface IUserService {
    void createUser(UserRequest request);

    void updateUser(int id, UserRequest request);

    void deleteUser(int id);
}
