package com.scaler.productservicejune2024.controllerAdvice;

import com.scaler.productservicejune2024.dtos.ExceptionDto;
import com.scaler.productservicejune2024.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handlerAirthmaticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Airthmatic Exception has happened");
        exceptionDto.setSolution("I don't know , Please try again");


        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto ,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handlerArrayIndexOutOfBoundsException(){
        ResponseEntity<String> response = new ResponseEntity<>(
                "Array Index Out Of Bounds Exception has happened",
                HttpStatus.BAD_REQUEST
        );

        return response;
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handlerNullPointerException(){
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "handler Null Pointer Exception has happened",
//                HttpStatus.NOT_FOUND
//        );
//
//        return response;
//    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handlerProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product Not Found");
        exceptionDto.setSolution("Please try again later with valid id");


        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto ,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }
}
