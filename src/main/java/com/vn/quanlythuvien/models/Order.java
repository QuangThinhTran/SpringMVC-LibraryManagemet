package com.vn.quanlythuvien.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rental_date")
    private Date rentalDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}
