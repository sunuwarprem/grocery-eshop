package com.prem.grocery_eshop.exception;

public class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message) {
            super(message);
        }
    }

