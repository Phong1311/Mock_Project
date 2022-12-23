package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OderDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name= "oderId", nullable = false)
    private OderList oderList;

    @ManyToOne
    @JoinColumn(name= "productId", nullable = false)
    private Product product;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "salePrice", nullable = false)
    private int salePrice;


}