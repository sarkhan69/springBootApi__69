package com.example.twoApi.models;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    public Book(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }
}
