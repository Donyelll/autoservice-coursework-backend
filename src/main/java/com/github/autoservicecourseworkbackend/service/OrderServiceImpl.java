package com.github.autoservicecourseworkbackend.service;


import com.github.autoservicecourseworkbackend.dto.request.RequestOrder;
import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;
import com.github.autoservicecourseworkbackend.entity.*;
import com.github.autoservicecourseworkbackend.mapper.OrderMapper;
import com.github.autoservicecourseworkbackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final MechanicService mechanicService;
    private final ServiceTypeService serviceTypeService;
    private final MaterialsService materialsService;
    private final TimeLimitService timeLimitService;
    private final OrderMapper mapper;

    @Override
    public Optional<OrderResponse> create(RequestOrder requestOrder) {
        CustomerEntity customer = customerService.getEntityById(requestOrder.getCustomerId()).get();
        MechanicEntity mechanic = mechanicService.getEntityById(requestOrder.getMechanicId()).get();
        ServiceTypeEntity service = serviceTypeService.getEntityById(requestOrder.getServiceId()).get();
        MaterialsEntity materials = materialsService.getEntityById(requestOrder.getMaterialsId()).get();
        TimeLimitEntity timeLimit = timeLimitService.getEntityById(requestOrder.getTimeLimitId()).get();
        OrderEntity order = new OrderEntity(customer,mechanic,service,timeLimit,materials);
        return Optional.of(orderRepository.save(order)).map(mapper::toResponse);
    }

    @Override
    public Optional<OrderResponse> getById(int id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if(orderEntity.isEmpty()){
            return Optional.empty();
        }
        return orderEntity.map(mapper::toResponse);
    }

    public List<OrderResponse> getOrdersByCustomerId(int id) {
        return orderRepository.findAllByCustomer_Id(id).stream().map(mapper::toResponse).toList();
    }

    public List<OrderResponse> getOrdersByMechanicId(int id) {
        return orderRepository.findAllByMechanic_Id(id).stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<OrderResponse> getAll() {
        return orderRepository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}
