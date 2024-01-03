package com.github.autoservicecourseworkbackend.service;


import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.dto.response.ServiceTypeResponse;
import com.github.autoservicecourseworkbackend.mapper.ServiceTypeMapper;
import com.github.autoservicecourseworkbackend.repository.ServiceTypeRepository;
import com.github.autoservicecourseworkbackend.entity.ServiceTypeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;
    private final ServiceTypeMapper mapper;

    @Override
    public Optional<ServiceTypeEntity> getEntityById(Integer id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public List<ServiceTypeResponse> getAll() {
        return serviceTypeRepository.findAll().stream().map(mapper::toResponse).toList();
    }

}
