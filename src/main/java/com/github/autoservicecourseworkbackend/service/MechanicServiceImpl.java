package com.github.autoservicecourseworkbackend.service;


import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.request.RequestMechanic;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import com.github.autoservicecourseworkbackend.mapper.CustomerMapper;
import com.github.autoservicecourseworkbackend.mapper.MechanicMapper;
import com.github.autoservicecourseworkbackend.repository.MechanicRepository;
import com.github.autoservicecourseworkbackend.entity.MechanicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;
    private final MechanicMapper mapper;

    @Override
    public Optional<Integer> create(RequestMechanic requestMechanic) {
        MechanicEntity mechanicEntity = MechanicEntity.create(requestMechanic);
        return Optional.of(mechanicRepository.save(mechanicEntity).getId());
    }

    @Override
    public Optional<MechanicResponse> getById(int id) {
        Optional<MechanicEntity> customerEntity = mechanicRepository.findById(id);
        if (customerEntity.isEmpty()) {
            return Optional.empty();
        }
        return customerEntity.map(mapper::toResponse);
    }

    @Override
    public Optional<MechanicResponse> login(RequestMechanic requestMechanic) {
        return mechanicRepository.findFirstByLoginAndPassword(requestMechanic.getLogin(), requestMechanic.getPassword()).map(mapper::toResponse);
    }

    @Override
    public Optional<MechanicEntity> getEntityById(int id) {
        return mechanicRepository.findById(id);
    }

    @Override
    public List<MechanicResponse> getAll() {
        List<MechanicEntity> customerEntityList = mechanicRepository.findAll();
        return customerEntityList.stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<MechanicResponse> getAllMechanicsByServiceId(int id) {
        return mechanicRepository.findAllByServices_IdIs(id).stream().map(mapper::toResponse).toList();
    }

    @Override
    public void delete(int id) {
        mechanicRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        mechanicRepository.deleteAll();
    }
}
