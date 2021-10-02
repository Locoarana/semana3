package com.example.semana3.common;


import com.example.semana3.dto.OrderRequest;
import com.example.semana3.exception.IncorrectOrderRequestException;

public class OrderValidator {
    public static boolean validateOrder(OrderRequest order){
        if (order.getProducts()==null || order.getProducts().isEmpty()){
            throw new IncorrectOrderRequestException("Un pedido debe tener productos");
        }
        return true;
    }
}
