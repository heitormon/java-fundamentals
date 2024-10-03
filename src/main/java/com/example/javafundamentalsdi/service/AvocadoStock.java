package com.example.javafundamentalsdi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AvocadoStock {
    private Integer quantity;
    private HashMap<String, List<Integer>> allocations;

    void setupStock() {
        quantity = 10;
        allocations = new HashMap<>();
    }

    void allocateOrder(Integer orderQuantity, String client) {
        if (orderQuantity > quantity) {
            throw new RuntimeException("Order quantity exceeds stock limit");
        }
        if (allocations.containsKey(client)) {
            allocations.get(client).add(orderQuantity);
        } else {
            allocations.put(client, new ArrayList<>());
        }
        quantity += orderQuantity;
    }
}
