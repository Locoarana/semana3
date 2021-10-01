package com.example.semana3.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class OrderRequest {
    //La cuenta del cliente que genera una orden
    private String accountId;
    private List<Product> products;
}
