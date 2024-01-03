package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.mapper.CustomerMapper;
import com.github.autoservicecourseworkbackend.repository.CustomerRepository;
import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public Optional<Integer> create(RequestCustomer requestCustomer) {
        CustomerEntity customerEntity = CustomerEntity.create(requestCustomer);
        return Optional.of(customerRepository.save(customerEntity).getId());
    }

    @Override
    public Optional<CustomerResponse> getById(int id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if (customerEntity.isEmpty()) {
            return Optional.empty();
        }
        return customerEntity.map(mapper::toResponse);
    }

    @Override
    public Optional<CustomerEntity> getEntityById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<CustomerResponse> getAll() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        return customerEntityList.stream().map(mapper::toResponse).toList();
    }

    @Override
    public Optional<CustomerResponse> login(RequestCustomer requestCustomer) {
        return customerRepository.findFirstByLoginAndPassword(requestCustomer.getLogin(), requestCustomer.getPassword()).map(mapper::toResponse);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

}
