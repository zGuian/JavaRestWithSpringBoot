package com.estudos.JavaRestWithSpringBoot.Exceptions.Handler;

import com.estudos.JavaRestWithSpringBoot.Exceptions.ExceptionResponse;
import com.estudos.JavaRestWithSpringBoot.Exceptions.InvalidJwtAuthenticationException;
import com.estudos.JavaRestWithSpringBoot.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage() ,
                request.getDescription(false));
        return new ResponseEntity<>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage() ,
                request.getDescription(false));
        return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidJwtExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage() ,
                request.getDescription(false));
        return new ResponseEntity<>(exResponse, HttpStatus.FORBIDDEN);
    }
}
