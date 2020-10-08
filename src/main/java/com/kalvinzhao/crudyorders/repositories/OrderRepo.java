package com.kalvinzhao.crudyorders.repositories;

import com.kalvinzhao.crudyorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
