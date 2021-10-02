package com.example.semana3.handler;

import com.example.semana3.exception.IncorrectOrderRequestException;
import com.example.semana3.exception.OrderNotFoundException;
import com.example.semana3.exception.OrderServiceExceptResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice //Actua de controlador de excepciones
@RestController //Lo ponemos porque la respuesta debe ser Json
public class OrderServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception exception,
                                               WebRequest request) {
        OrderServiceExceptResponse response = new OrderServiceExceptResponse(
                exception.getMessage(), request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now()
        );
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(IncorrectOrderRequestException.class)
    public ResponseEntity<Object> handleIncorrectRequest(Exception exception,
                                                         WebRequest request) {
        OrderServiceExceptResponse response = new OrderServiceExceptResponse(
                exception.getMessage(), request.getDescription(false),
                HttpStatus.BAD_REQUEST, LocalDateTime.now()
        );
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(Exception exception,
                                                         WebRequest request) {
        OrderServiceExceptResponse response = new OrderServiceExceptResponse(
                exception.getMessage(), request.getDescription(false),
                HttpStatus.NOT_FOUND, LocalDateTime.now()
        );
        return new ResponseEntity<>(response, response.getStatus());
    }
}
