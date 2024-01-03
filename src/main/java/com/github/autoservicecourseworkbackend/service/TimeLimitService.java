package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.response.TimeLimitResponse;
import com.github.autoservicecourseworkbackend.entity.TimeLimitEntity;

import java.util.List;
import java.util.Optional;

public interface TimeLimitService {

    Optional<TimeLimitEntity> getEntityById(Integer id);

    List<TimeLimitResponse> getAll();

}
