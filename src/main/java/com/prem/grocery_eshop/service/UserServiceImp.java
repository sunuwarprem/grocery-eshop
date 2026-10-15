package com.prem.grocery_eshop.service;

import com.prem.grocery_eshop.dto.UserRequest;
import com.prem.grocery_eshop.dto.UserResponse;
import com.prem.grocery_eshop.exception.EmailAlreadyExists;
import com.prem.grocery_eshop.exception.UserNotFoundException;
import com.prem.grocery_eshop.mappers.UserMappers;
import com.prem.grocery_eshop.model.User;
import com.prem.grocery_eshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserResponse saveUser(UserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExists("Email already registered: " + request.email());
        }
        User user= UserMappers.toEntity(request);
        User savedUser=userRepository.save(user);
        return UserMappers.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(int id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        UserMappers.toUpdateEntity(request, user);
        User updatedUser = userRepository.save(user);
        return UserMappers.toUserResponse(updatedUser);
    }

    @Override
    public String deleteUser(int id) {
       if(!userRepository.existsById(id)){
          throw  new UserNotFoundException(("User not found by id "+id));
       }
       userRepository.deleteById(id);
       return "User deleted by Id : "+id;
    }

    @Override
    public UserResponse getUserById(int id) {
        User user=userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found by Id "+id));
        return UserMappers.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users=userRepository.findAll();
        if(users.isEmpty()){
            throw new RuntimeException("User doesnt not exists");
        }
        return users.stream().map(UserMappers::toUserResponse).toList();
    }
}
