package com.github.autoservicecourseworkbackend.mapper;

import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.dto.response.MaterialsResponse;
import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import com.github.autoservicecourseworkbackend.entity.MaterialsEntity;
import org.springframework.stereotype.Component;

@Component
public class MaterialsMapper {

    public MaterialsResponse toResponse(MaterialsEntity materialsEntity){
        return new MaterialsResponse(materialsEntity.getId(),materialsEntity.getName(),materialsEntity.getPriceCoef());
    }

}
