package com.vn.quanlythuvien.repositories;

import com.vn.quanlythuvien.models.Role;
import com.vn.quanlythuvien.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByPhone(String phone);
    User findByUsernameAndPassword(String username, String password);
    List<User> getUserByRole(Role role);

    @Query("SELECT u FROM User u " +
            "WHERE u.name LIKE %:keyword% " +
            "OR u.email LIKE %:keyword% " +
            "OR u.phone LIKE %:keyword% " +
            "Group by u.id, u.username, u.email, u.phone")
    List<User> searchUser(String keyword);
}
