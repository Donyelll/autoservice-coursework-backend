package com.github.autoservicecourseworkbackend.mapper;

import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;
import com.github.autoservicecourseworkbackend.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final CustomerMapper customerMapper;
    private final MechanicMapper mechanicMapper;
    private final MaterialsMapper materialsMapper;
    private final ServiceTypeMapper serviceTypeMapper;
    private final TimeLimitMapper timeLimitMapper;

    public OrderResponse toResponse(OrderEntity orderEntity){
        return new OrderResponse().setId(orderEntity.getId())
                .setCustomer(customerMapper.toDto(orderEntity.getCustomer()))
                .setMechanic(mechanicMapper.toDto(orderEntity.getMechanic()))
                .setMaterials(materialsMapper.toResponse(orderEntity.getMaterials()))
                .setService(serviceTypeMapper.toResponse(orderEntity.getService()))
                .setTimeLimit(timeLimitMapper.toResponse(orderEntity.getTimeLimit()))
                .setTotalPrice(orderEntity.getTotalPrice());
    }

}
