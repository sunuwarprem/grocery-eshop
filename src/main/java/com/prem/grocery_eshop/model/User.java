package com.prem.grocery_eshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name="user_name", nullable = false, length = 100)
    private String userName;
    @Column(name="password", nullable = false, length = 500)
    private String password;
    @DateTimeFormat(pattern = "yyyy-mm-DD")
    private LocalDate dob;
    @Column(name="phone_no",length=15)
    private long phoneNo;
    @Column(unique = true, length = 200)
    private String email;
}
