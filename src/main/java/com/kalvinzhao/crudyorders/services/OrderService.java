package com.kalvinzhao.crudyorders.services;

import com.kalvinzhao.crudyorders.models.Order;

public interface OrderService {
    Order save(Order order);

    Order findAgentById(long id);
}
