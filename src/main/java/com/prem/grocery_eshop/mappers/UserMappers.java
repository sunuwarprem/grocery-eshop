package com.prem.grocery_eshop.mappers;

import com.prem.grocery_eshop.dto.UserRequest;
import com.prem.grocery_eshop.dto.UserResponse;
import com.prem.grocery_eshop.model.User;

public final class UserMappers {

    private UserMappers(){}

    public static User toEntity(UserRequest request){
        User user=new User();
        user.setFullName(request.fullName());
        user.setUserName(request.userName());
        user.setPassword(request.password());
        user.setDob(request.dob());
        user.setPhoneNo(request.phoneNo());
        user.setEmail(request.email());
        return user;
    }
    public static UserResponse toUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getUserName(),
             //   user.getPassword(),
                user.getDob(),
                user.getPhoneNo(),
                user.getEmail()
        );
    }
    public static void toUpdateEntity(UserRequest request, User user){
        user.setFullName(request.fullName());
        user.setUserName(request.userName());
        user.setPassword(request.password());
        user.setDob(request.dob());
        user.setPhoneNo(request.phoneNo());
        user.setEmail(request.email());
    }


}
