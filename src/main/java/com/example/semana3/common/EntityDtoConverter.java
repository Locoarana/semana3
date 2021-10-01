package com.example.semana3.common;

import com.example.semana3.dto.OrderResponse;
import com.example.semana3.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public OrderResponse convertEntityToDto(Order order){
        return modelMapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> convertEntityToDto(List<Order> orders){
        return orders.stream()
                .map(order->convertEntityToDto(order)) //igual a this::converEntutyToDto
                .collect(Collectors.toList());
    }

}
