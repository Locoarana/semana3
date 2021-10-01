package com.example.semana3.controller;

import com.example.semana3.common.EntityDtoConverter;
import com.example.semana3.dto.OrderRequest;
import com.example.semana3.dto.OrderResponse;
import com.example.semana3.entities.Order;
import com.example.semana3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    //http://localhost:8080/orders
    //Y viene con el verbo get, usar @GetMapping,
    // "ResponseEntity<>"esto transformaa formato json
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> findAll(){
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<List<OrderResponse>>(
                entityDtoConverter.convertEntityToDto(orders),
                HttpStatus.OK);
    }

    @GetMapping("orders/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId){
        Order order = orderService.findById(orderId);
        return new ResponseEntity<OrderResponse>(
                entityDtoConverter.convertEntityToDto(order),
                HttpStatus.OK);
    }

    //ResponseBody convierte formate json a formato java
    @PostMapping("/orders")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payLoad){
        Order order = orderService.createOrder(payLoad);
        return new ResponseEntity<>(
                entityDtoConverter.convertEntityToDto(order),
                HttpStatus.CREATED);
    }
}
