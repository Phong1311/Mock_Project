package com.vti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String status;

    private String avatarUrl;


}
