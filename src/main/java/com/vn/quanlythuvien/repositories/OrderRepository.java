package com.vn.quanlythuvien.repositories;

import com.vn.quanlythuvien.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByStatus(String status);
    List<Order> findByUserId(Integer userId);

    @Query("SELECT o FROM Order o ORDER BY o.id DESC")
    List<Order> getAllDesc();
}
