package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "employeeId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employeeName", nullable = false, length = 50, unique = true)
    private String employeeName;

    @Column(name = "`password`", nullable = false, length = 800)
    private String password;

    @Column(name = "`role`", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "`status`", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status = UserStatus.NOT_ACTIVE;

    @Column(name = "avatarUrl")
    private String avatarUrl;
    public enum Role {
        ADMIN, STAFF;
    }
}