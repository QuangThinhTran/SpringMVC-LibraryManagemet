package com.vn.quanlythuvien.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rental_date")
    private Date rentalDate = new Date();

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int customerId;

    @Column(name = "book_id", nullable = false)
    private int bookId;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails;

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
