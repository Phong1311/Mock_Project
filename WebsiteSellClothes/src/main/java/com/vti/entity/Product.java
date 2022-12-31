package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productName", nullable = false, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "catalogId")
    private Catalog catalog;

    @Column(name = "`describe`", nullable = false, length = 1000)
    private String describe;

    @Column(name = "size", nullable = false, length = 10)
    private String size;

    @Column(name = "amount", nullable = false)
    private short amount;

    @Column(name = "purchase_Price", nullable = false)
    private int purchasePrice;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "salePrice")
    private int salePrice;

    @Column(name = "review")
    private String review;

    @CreatedDate
    @Column(name = "createDate")
    private LocalDateTime createDate;

    @OneToOne(mappedBy = "product")
    private Image image;


    @OneToMany(mappedBy = "product")
    private List<OderDetail> oderDetails;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;

    @OneToMany(mappedBy = "product")
    private List<CreatorProduct> creatorProducts;

    public Product(String name, Catalog catalog, String describe, String size, short amount, int purchasePrice, int price, int salePrice) {
        this.name = name;
        this.catalog = catalog;
        this.describe = describe;
        this.size = size;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.salePrice = salePrice;
    }
}