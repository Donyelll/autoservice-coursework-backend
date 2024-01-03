package com.github.autoservicecourseworkbackend.mapper;

import com.github.autoservicecourseworkbackend.dto.response.ServiceTypeResponse;
import com.github.autoservicecourseworkbackend.entity.ServiceTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ServiceTypeMapper {

    public ServiceTypeResponse toResponse(ServiceTypeEntity serviceTypeEntity){
        return new ServiceTypeResponse(serviceTypeEntity.getId(),serviceTypeEntity.getName(),serviceTypeEntity.getBasePrice());
    }

}
