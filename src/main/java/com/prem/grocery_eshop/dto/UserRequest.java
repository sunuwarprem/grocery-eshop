package com.prem.grocery_eshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(name="UserRequest", description = "Payload to create/update users")
public record UserRequest(
        @Schema(example = "john smith", description = "User Full Name")
        @NotBlank(message = "Full name is required")
        @Size(min = 3, max = 30, message = "Full name must be 3 to 30 characters")
        String fullName,

        @Schema(example = "john")
        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 30, message = "Username must be 3 to 30 characters")
        String userName,

        @Schema(example = "Secret@123")
        @NotBlank(message = "Password is required")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$",
                message = "Min 8 chars, 1 uppercase, 1 digit")
        String password,

        @Schema(example = "2000-05-20", type = "string", format = "date")
        @NotNull(message = "Date of birth is required")
        @Past(message = "Date of birth must be in the past")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate dob,

        @Schema(example = "9876543210")
        @Min(value = 1000000000L, message = "Phone number must be 10 digits")
        @Max(value = 9999999999L, message = "Phone number must be 10 digits")
        long phoneNo,

        @Schema(example = "john@example.com")
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email
) {
}
