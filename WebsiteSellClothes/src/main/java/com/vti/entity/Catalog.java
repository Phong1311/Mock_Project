package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`name`", nullable = false, length = 30)
    private String name;

    @OneToOne(mappedBy = "catalog")
    private Product product;

    public Catalog(String name) {
        this.name = name;
    }
}