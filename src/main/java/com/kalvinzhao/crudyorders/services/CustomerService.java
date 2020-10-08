package com.kalvinzhao.crudyorders.services;

import com.kalvinzhao.crudyorders.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> findAllCustomerOrders(); // STEP 2, IMPLETMENT THIS. STEP 3, IMPLEMENT NEXT STEP IN CustomerServiceImp

    Customer findCustomerById(long id);

    List<Customer> findCustomerLikeName(String name);
}
