package com.prem.grocery_eshop.service;

import com.prem.grocery_eshop.dto.UserRequest;
import com.prem.grocery_eshop.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse saveUser(UserRequest request);
    UserResponse updateUser(int id,UserRequest request);
    String deleteUser(int id);
    UserResponse getUserById(int id);
    List<UserResponse> getAllUsers();
}
