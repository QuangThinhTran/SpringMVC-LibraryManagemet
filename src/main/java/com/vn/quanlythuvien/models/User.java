package com.vn.quanlythuvien.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 50)
    private String phone;

    @Column(length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role=" + (role != null ? role.getId() : null) +
                '}';
    }
}
