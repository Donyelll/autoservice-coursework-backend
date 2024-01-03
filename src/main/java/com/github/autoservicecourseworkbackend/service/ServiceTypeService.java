package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.dto.response.ServiceTypeResponse;
import com.github.autoservicecourseworkbackend.entity.MechanicEntity;
import com.github.autoservicecourseworkbackend.entity.ServiceTypeEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceTypeService {

    Optional<ServiceTypeEntity> getEntityById(Integer id);

    List<ServiceTypeResponse> getAll();


}
