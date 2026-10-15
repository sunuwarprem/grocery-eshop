package com.prem.grocery_eshop.controller;

import com.prem.grocery_eshop.dto.UserRequest;
import com.prem.grocery_eshop.dto.UserResponse;
import com.prem.grocery_eshop.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request){
        UserResponse response=userService.saveUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(int id,@RequestBody UserRequest request){
        UserResponse response=userService.updateUser(id,request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        String response=userService.deleteUser(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id){
        UserResponse response=userService.getUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> userResponses=userService.getAllUsers();
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

}
