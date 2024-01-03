package com.github.autoservicecourseworkbackend.service;

import com.github.autoservicecourseworkbackend.dto.request.RequestOrder;
import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderResponse> create(RequestOrder requestOrder);

    Optional<OrderResponse> getById(int id);

    List<OrderResponse> getOrdersByCustomerId(int id);

    List<OrderResponse> getOrdersByMechanicId(int id);

    List<OrderResponse> getAll();

    void delete(int id);

}
