package com.kalvinzhao.crudyorders.services;

import com.kalvinzhao.crudyorders.models.Customer;
import com.kalvinzhao.crudyorders.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional //anytime if any method is transactional, make the whole class transactional
@Service(value = "customerServices")
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepo customerrepos;

    @Override
    public List<Customer> findAllCustomerOrders() {  // STEP 3
        List<Customer> list = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long id) {
        Customer returnCustomer = customerrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
        return returnCustomer;
    }

    @Override
    public List<Customer> findCustomerLikeName(String name) {
        List<Customer> returnList = customerrepos.findByCustnameContainingIgnoringCase(name);
        return returnList;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerrepos.save(customer);
    }

}
