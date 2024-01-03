package com.github.autoservicecourseworkbackend.mapper;

import com.github.autoservicecourseworkbackend.dto.response.TimeLimitResponse;
import com.github.autoservicecourseworkbackend.entity.TimeLimitEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeLimitMapper {

    public TimeLimitResponse toResponse(TimeLimitEntity timeLimitEntity){
        return new TimeLimitResponse(timeLimitEntity.getId(),timeLimitEntity.getDuration(),timeLimitEntity.getPriceCoef());
    }

}
