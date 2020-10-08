package com.kalvinzhao.crudyorders.repositories;

import com.kalvinzhao.crudyorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment, Long> {
}
