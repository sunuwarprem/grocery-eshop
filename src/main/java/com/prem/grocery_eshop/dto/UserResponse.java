package com.prem.grocery_eshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record UserResponse(
        @Schema(example = "1", description = "auto generated primary key")
        int id,

        @Schema(example = "john smith", description = "User Full Name")
        String fullName,

        @Schema(example = "john")
        String userName,

        @Schema(example = "2000-05-20")
        LocalDate dob,

        @Schema(example = "9876543210")
        long phoneNo,

        @Schema(example = "john@example.com")
        String email
) {
}
