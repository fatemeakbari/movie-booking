package com.example.moviebooking.exceptionHandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        return super.handleMissingPathVariable(ex, headers, status, request);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e,
                                                             WebRequest request){

        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setMessage("Record not found");
        response.setDetails(Arrays.asList(e.getMessage()));
        response.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity(response, response.getHttpStatus());

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex
                                                                           ,WebRequest request){

        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setMessage("Invalid input");
        response.setDetails(Arrays.asList(ex.getMessage()));
        response.setHttpStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(response, response.getHttpStatus());
    }
//    @ExceptionHandler(EmptyResultDataAccessException.class)
//    protected ResponseEntity<Object> handleEmpty(EmptyResultDataAccessException ex
//            ,WebRequest request){
//
//        ApiExceptionResponse response = new ApiExceptionResponse();
//        response.setMessage("Invalid input");
//        response.setDetails(Arrays.asList(ex.getMessage()));
//        response.setHttpStatus(HttpStatus.BAD_REQUEST);
//        return new ResponseEntity(response, response.getHttpStatus());
//    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ApiExceptionResponse response = new ApiExceptionResponse();
        List<String> details = new ArrayList<>();

        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());
        }
        response.setMessage("Invalid input");
        response.setDetails(details);
        response.setHttpStatus(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }


}
