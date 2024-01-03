package com.github.autoservicecourseworkbackend.controller;


import com.github.autoservicecourseworkbackend.dto.request.RequestOrder;
import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;
import com.github.autoservicecourseworkbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody RequestOrder requestOrder){
        Optional<OrderResponse> createdOrder = orderService.create(requestOrder);
        if(createdOrder.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder.get());
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable Integer id){
        Optional<OrderResponse> responseOrder = orderService.getById(id);
        if(responseOrder.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(responseOrder.get());
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
