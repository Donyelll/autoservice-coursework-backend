package com.github.autoservicecourseworkbackend.mapper;

import com.github.autoservicecourseworkbackend.dto.CustomerDto;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponse toResponse(CustomerEntity customerEntity){
        return new CustomerResponse().setId(customerEntity.getId())
                .setName(customerEntity.getName())
                .setSurname(customerEntity.getSurname())
                .setLogin(customerEntity.getLogin());
    }

    public CustomerDto toDto(CustomerEntity customerEntity){
        return new CustomerDto(customerEntity.getId(),customerEntity.getName(),customerEntity.getSurname());
    }
}
