package com.prem.grocery_eshop.exception;

public class EmailAlreadyExists extends RuntimeException{

    public EmailAlreadyExists(String message){
        super(message);
    }

}
