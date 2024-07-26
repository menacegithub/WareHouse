package org.example.extratomeee.model;

import jakarta.persistence.*;

public class OutPutProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private Product product;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private Double price;
    private Integer outPutId;
}
