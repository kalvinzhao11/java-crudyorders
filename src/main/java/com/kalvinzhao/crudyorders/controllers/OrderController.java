package com.kalvinzhao.crudyorders.controllers;

import com.kalvinzhao.crudyorders.models.Order;
import com.kalvinzhao.crudyorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderServices;

    @GetMapping(value = "/order/{id}", produces = {"application/json"})
    public ResponseEntity<?> findByOrderId(@PathVariable long id) {
        Order returnOrder = orderServices.findAgentById(id);
        return new ResponseEntity<>(returnOrder, HttpStatus.OK);
    }
}
