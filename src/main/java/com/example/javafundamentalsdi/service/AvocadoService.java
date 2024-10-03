package com.example.javafundamentalsdi.service;

public interface AvocadoService {
    record Order(Integer quantity, String clientName){}
    record Receipt(Double price, Integer quantity, Double totalPrice){}
    Receipt buy(Order order);
}
