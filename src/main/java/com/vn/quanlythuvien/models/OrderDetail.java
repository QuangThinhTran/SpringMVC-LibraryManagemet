package com.vn.quanlythuvien.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + (order != null ? order.getId() : null) +
                ", book=" + (book != null ? book.getId() : null) +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}
