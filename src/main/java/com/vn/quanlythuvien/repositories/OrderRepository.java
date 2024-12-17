package com.vn.quanlythuvien.repositories;

import com.vn.quanlythuvien.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByEmail(Integer userId);
    List<Order> findByStatus(String status);
    List<Order> findByUserId(Integer userId);
}
