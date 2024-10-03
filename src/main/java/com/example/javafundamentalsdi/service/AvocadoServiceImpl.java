package com.example.javafundamentalsdi.service;

public class AvocadoServiceImpl implements  AvocadoService{
    @Override
    public Receipt buy(Order order) {
        //setup stock
        AvocadoStock avocadoStock = new AvocadoStock();
        avocadoStock.setupStock();
        //allocate stock with order
        avocadoStock.allocateOrder(order.quantity(),order.clientName());
        //setup price
        AvocadoPrice avocadoPrice = new AvocadoPrice();
        avocadoPrice.setup();
        //calculate total price
        Double price = avocadoPrice.getPrice();
        Double totalPrice = price * order.quantity();
        return new Receipt(price, order.quantity(), totalPrice);
    }
}
