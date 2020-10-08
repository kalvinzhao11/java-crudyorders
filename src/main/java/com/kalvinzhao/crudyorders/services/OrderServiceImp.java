package com.kalvinzhao.crudyorders.services;

import com.kalvinzhao.crudyorders.models.Order;
import com.kalvinzhao.crudyorders.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional //anytime if any method is transactional, make the whole class transactional
@Service(value = "orderServices")
public class OrderServiceImp implements OrderService{

    @Autowired
    OrderRepo orderrepos;

    @Override
    public Order findAgentById(long id) {
        Order order = orderrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order " + id + " Not Found"));
        return order;
    }

    @Transactional
    @Override
    public Order save(Order order) {
        return orderrepos.save(order);
    }
}
