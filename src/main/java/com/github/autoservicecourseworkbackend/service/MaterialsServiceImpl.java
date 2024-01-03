package com.github.autoservicecourseworkbackend.service;


import com.github.autoservicecourseworkbackend.dto.response.MaterialsResponse;
import com.github.autoservicecourseworkbackend.mapper.MaterialsMapper;
import com.github.autoservicecourseworkbackend.repository.MaterialsRepository;
import com.github.autoservicecourseworkbackend.entity.MaterialsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialsServiceImpl implements MaterialsService {

    private final MaterialsRepository materialsRepository;
    private final MaterialsMapper mapper;

    @Override
    public Optional<MaterialsEntity> getEntityById(Integer id) {
        return materialsRepository.findById(id);
    }

    @Override
    public List<MaterialsResponse> getAll() {
        return materialsRepository.findAll().stream().map(mapper::toResponse).toList();
    }

}
