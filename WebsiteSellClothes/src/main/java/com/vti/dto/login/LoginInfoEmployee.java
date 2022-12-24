package com.vti.dto.login;

import com.vti.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoEmployee {

    private String token;

    private String employeeName;

    private Employee.Role role;

    private String status;


}
