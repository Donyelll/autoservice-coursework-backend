package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Integer> create(RequestCustomer requestCustomer);

    Optional<CustomerResponse> getById(int id);

    Optional<CustomerEntity> getEntityById(int id);

    Optional<CustomerResponse> login(RequestCustomer requestCustomer);

    List<CustomerResponse> getAll();

    void delete(int id);

    void deleteAll();

}
