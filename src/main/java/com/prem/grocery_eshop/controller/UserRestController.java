package com.prem.grocery_eshop.controller;

import com.prem.grocery_eshop.dto.UserRequest;
import com.prem.grocery_eshop.dto.UserResponse;
import com.prem.grocery_eshop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name="User info", description="User info system API")
public class UserRestController {

    public final UserService userService;
    @Operation(
            summary = "User create",
            description = "Create a new User",
            responses = {
                    @ApiResponse(
                            responseCode = "201", description = "User Created",
                            content = @Content(schema = @Schema(implementation = UserResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400", description = "Validation Error", content = @Content
                            )

    }
    )
    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest request){
        UserResponse response=userService.saveUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Update User", description = "User Updated",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Successfully Updated",
                            content = @Content(schema = @Schema(implementation = UserResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400", description = "Validation Error",
                            content = @Content
                    )
            }
    )
    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(int id,@RequestBody @Valid UserRequest request){
        /*UserResponse response=userService.updateUser(id,request);
        return new ResponseEntity<>(response, HttpStatus.OK);*/
        return ResponseEntity.ok(userService.updateUser(id, request));
    }
    @Operation(
            summary = "Delete user bu Id", description = "User deleted Successfully",
            responses = {
                    @ApiResponse(
                            responseCode = "402", description = "Deleted successfully",
                            content = @Content(schema = @Schema(implementation = UserResponse.class))
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        /*String response=userService.deleteUser(id);
        return new ResponseEntity<>(response,HttpStatus.OK);*/
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @Operation(
            summary = "Get User by Id", description = "user by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "List user by Id",
                            content = @Content(schema = @Schema(implementation = UserResponse.class))
                    )
            }

    )
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id){
       /* UserResponse response=userService.getUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);*/
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @Operation(
            summary = "Get all Users", description = "All users Listed",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Listed all Users",
                            content = @Content(schema = @Schema(implementation = UserResponse.class))
                    )
            }

    )
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> userResponses=userService.getAllUsers();
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

}
