package com.vti.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoResponse {
    private String token;
    private String type = "Bearer";
    private int id;
    private String username;
    private String email;
    private String role;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String status;

    public UserInfoResponse(String accessToken, int id, String username, String email, String role, String firstName, String lastName, String phoneNumber, String address, String status) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }


}