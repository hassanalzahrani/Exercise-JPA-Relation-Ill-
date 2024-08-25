package com.example.demo5.ControllAdviser;

import com.example.demo5.Api_exception.ApiException;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;

@ControllerAdvice
public class ControllerAdviser {

@ExceptionHandler(value = DataIntegrityViolationException.class)

    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
    return ResponseEntity.status(200).body(e.getMessage());
}
@ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity BadRequestException(BadRequestException e){
    return ResponseEntity.status(400).body(e.getMessage());
}
@ExceptionHandler(ApiException.class)
    public ResponseEntity ApiException(ApiException e){
    return ResponseEntity.status(200).body(e.getMessage());
}

}
