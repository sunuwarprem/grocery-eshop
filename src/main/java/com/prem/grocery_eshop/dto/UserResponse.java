package com.prem.grocery_eshop.dto;

import java.time.LocalDate;

public record UserResponse(
        int id,
        String fullName,
        String userName,
       // String password,
        LocalDate dob,
        long phoneNo,
        String email
) {
}
