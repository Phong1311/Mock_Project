package com.vti.entity;

import com.vti.dto.CatalogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Image`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "imageId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(name = "imageUrl", nullable = false, length = 100)
    private String imageUrl;

}