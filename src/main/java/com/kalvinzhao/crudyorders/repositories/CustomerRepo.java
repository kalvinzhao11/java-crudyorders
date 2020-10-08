package com.kalvinzhao.crudyorders.repositories;

import com.kalvinzhao.crudyorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    List<Customer> findByCustnameContainingIgnoringCase(String likename);
}
