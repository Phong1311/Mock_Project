package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable {

    private static final long serialVersionUID = 1L;


    @EmbeddedId
    private GioHangKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private Product product;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class GioHangKey implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "userId")
        private int userId;

        @Column(name = "productId")
        private int productId;


    }

}