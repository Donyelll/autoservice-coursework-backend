package com.github.autoservicecourseworkbackend.service;


import com.github.autoservicecourseworkbackend.dto.response.ServiceTypeResponse;
import com.github.autoservicecourseworkbackend.dto.response.TimeLimitResponse;
import com.github.autoservicecourseworkbackend.mapper.TimeLimitMapper;
import com.github.autoservicecourseworkbackend.repository.TimeLimitRepository;
import com.github.autoservicecourseworkbackend.entity.TimeLimitEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeLimitServiceImpl implements TimeLimitService {

    private final TimeLimitRepository timeLimitRepository;
    private final TimeLimitMapper mapper;

    @Override
    public Optional<TimeLimitEntity> getEntityById(Integer id) {
        return timeLimitRepository.findById(id);
    }

    @Override
    public List<TimeLimitResponse> getAll() {
        return timeLimitRepository.findAll().stream().map(mapper::toResponse).toList();
    }

}
