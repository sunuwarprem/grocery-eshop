package com.prem.grocery_eshop.dto;

import java.time.LocalDate;

public record UserRequest(
        String fullName,
        String userName,
        String password,
        LocalDate dob,
        long phoneNo,
        String email
) {
}
