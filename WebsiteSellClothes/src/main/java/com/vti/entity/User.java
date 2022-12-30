package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`User`")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userName", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "`password`", nullable = false, length = 800)
    private String password;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Formula("concat(firstName, ' ', lastName)")
    private String fullName;

    @Column(name = "phoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "address", length = 300)
    private String address;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`status`", nullable = false)
    private UserStatus status = UserStatus.NOT_ACTIVE;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<OderList> oderLists;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<CreatorProduct> creatorProducts;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}