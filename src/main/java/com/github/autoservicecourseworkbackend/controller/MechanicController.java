package com.github.autoservicecourseworkbackend.controller;

import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.request.RequestMechanic;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;
import com.github.autoservicecourseworkbackend.service.CustomerService;
import com.github.autoservicecourseworkbackend.service.MechanicService;
import com.github.autoservicecourseworkbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mechanics/")
@RequiredArgsConstructor
public class MechanicController {

    private final MechanicService mechanicService;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody RequestMechanic requestMechanic) {
        Optional<Integer> createdId = mechanicService.create(requestMechanic);
        if (createdId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdId.get());
    }

    @PostMapping("login")
    public ResponseEntity<MechanicResponse> login(@RequestBody RequestMechanic requestMechanic){
        Optional<MechanicResponse> response = mechanicService.login(requestMechanic);
        if (response.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response.get());
    }

    @GetMapping("{id}")
    public ResponseEntity<MechanicResponse> getById(@PathVariable Integer id) {
        Optional<MechanicResponse> mechanicResponse = mechanicService.getById(id);
        if (mechanicResponse.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(mechanicResponse.get());
    }

    @GetMapping("{id}/orders")
    public ResponseEntity<List<OrderResponse>> getOrders(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrdersByMechanicId(id));
    }


    @GetMapping
    public ResponseEntity<List<MechanicResponse>> getAll() {
        return ResponseEntity.ok(mechanicService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        mechanicService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll() {
        mechanicService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
