package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.response.MaterialsResponse;
import com.github.autoservicecourseworkbackend.entity.MaterialsEntity;

import java.util.List;
import java.util.Optional;

public interface MaterialsService {

    Optional<MaterialsEntity> getEntityById(Integer id);

    List<MaterialsResponse> getAll();

}
