package com.example.demo5.Api_exception;
public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}