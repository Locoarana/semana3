package com.example.semana3.service;
import com.example.semana3.common.OrderValidator;
import com.example.semana3.dto.OrderRequest;
import com.example.semana3.dto.OrderResponse;
import com.example.semana3.entities.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    public Order createOrder(OrderRequest orderRequest){
        OrderValidator.validateOrder(orderRequest);
        Order response= new Order();
        response.setOrderId("9999999");
        response.setStatus("Pending");
        response.setAccountId(orderRequest.getAccountId());
        response.setTotalAmount(360.78);
        response.setTotalTax(34.90);
        response.setTransactionDate(new Date());

        return response;
    }

    public List<Order> findAllOrders(){
        List<Order> orders = new ArrayList<>();

        Order response= new Order();
        response.setOrderId("1");
        response.setStatus("Pending");
        response.setAccountId("230487");
        response.setTotalAmount(360.78);
        response.setTotalTax(34.90);
        response.setTransactionDate(new Date());

        Order response2= new Order();
        response2.setOrderId("2");
        response2.setStatus("Pending");
        response2.setAccountId("34586");
        response2.setTotalAmount(100.00);
        response2.setTotalTax(10.00);
        response2.setTransactionDate(new Date());
        orders.add(response);
        orders.add(response2);

        return orders;
    }

    public Order findById(String orderId){
        Order response= new Order();
        response.setOrderId(orderId);
        response.setStatus("Pending");
        response.setAccountId("230487");
        response.setTotalAmount(360.78);
        response.setTotalTax(34.90);
        response.setTransactionDate(new Date());
        return response;
    }
}
