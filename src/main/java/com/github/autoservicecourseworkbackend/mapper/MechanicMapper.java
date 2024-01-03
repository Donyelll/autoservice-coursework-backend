package com.github.autoservicecourseworkbackend.mapper;

import com.github.autoservicecourseworkbackend.dto.MechanicDto;
import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.entity.MechanicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MechanicMapper {

    private final ServiceTypeMapper mapper;

    public MechanicResponse toResponse(MechanicEntity mechanicEntity){
        return new MechanicResponse().setId(mechanicEntity.getId())
                .setName(mechanicEntity.getName())
                .setSurname(mechanicEntity.getSurname())
                .setLogin(mechanicEntity.getLogin())
                .setPassword(mechanicEntity.getPassword())
                .setServices(mechanicEntity.getServices().stream().map(mapper::toResponse).toList());
    }

    public MechanicDto toDto(MechanicEntity mechanicEntity){
        return new MechanicDto(mechanicEntity.getId(),mechanicEntity.getName(),mechanicEntity.getSurname());
    }

}
