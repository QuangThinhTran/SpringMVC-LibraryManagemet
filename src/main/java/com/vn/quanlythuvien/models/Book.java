package com.vn.quanlythuvien.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 255)
    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "year_of_publication")
    private Date yearOfPublication;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(length = 250)
    private String image;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @Transient
    private Integer typeId;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", quantity=" + quantity +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", type=" + (type != null ? type.getId() : null) +
                '}';
    }
}
