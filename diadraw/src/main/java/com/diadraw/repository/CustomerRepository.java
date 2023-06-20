package com.diadraw.repository;

import com.diadraw.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findByEmail(String email);

    Customer findByPhoneNumber(String phoneNumber);
}
