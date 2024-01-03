package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.request.RequestMechanic;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import com.github.autoservicecourseworkbackend.entity.MechanicEntity;

import java.util.List;
import java.util.Optional;

public interface MechanicService {

    Optional<Integer> create(RequestMechanic requestMechanic);

    Optional<MechanicResponse> login(RequestMechanic requestMechanic);

    Optional<MechanicResponse> getById(int id);

    Optional<MechanicEntity> getEntityById(int id);

    List<MechanicResponse> getAll();

    List<MechanicResponse> getAllMechanicsByServiceId(int id);

    void delete(int id);

    void deleteAll();

}
