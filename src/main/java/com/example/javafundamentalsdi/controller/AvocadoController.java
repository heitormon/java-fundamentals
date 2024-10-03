package com.example.javafundamentalsdi.controller;

import com.example.javafundamentalsdi.service.AvocadoService;
import com.example.javafundamentalsdi.service.AvocadoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avocado")
public class AvocadoController {

    @PostMapping("/buy")
    public ReceiptDto buy(@RequestBody OrderDto order, @RequestHeader("client-name") String clientName) {
        AvocadoServiceImpl avocadoService = new AvocadoServiceImpl();
        AvocadoService.Receipt receipt = avocadoService.buy(new AvocadoService.Order(order.quantity(), clientName));
        return new ReceiptDto(receipt.price(), receipt.quantity(), receipt.totalPrice());
    }
}
