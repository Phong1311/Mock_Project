package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "productId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productName", nullable = false, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "catalogId", referencedColumnName = "id")
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

    @CreatedDate
    @Column(name = "createDate")
    private LocalDateTime createDate;

//    @Column(name = "createDate")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Date createdDate;

    @OneToMany(mappedBy = "product")
    private List<Image> image;

    @ManyToMany(mappedBy = "productList")
    private List<User> users;

    @OneToMany(mappedBy = "product")
    private List<OderDetail> oderDetails;

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