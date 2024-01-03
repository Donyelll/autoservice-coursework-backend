package com.github.autoservicecourseworkbackend.controller;


import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;
import com.github.autoservicecourseworkbackend.service.CustomerService;
import com.github.autoservicecourseworkbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody RequestCustomer requestCustomer) {
        Optional<Integer> createdId = customerService.create(requestCustomer);
        if (createdId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdId.get());
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Integer id) {
        Optional<CustomerResponse> responseCustomer = customerService.getById(id);
        if (responseCustomer.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(responseCustomer.get());
    }

    @GetMapping("{id}/orders")
    public ResponseEntity<List<OrderResponse>> getOrders(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("login")
    public ResponseEntity<CustomerResponse> login(@RequestBody RequestCustomer requestCustomer){
        Optional<CustomerResponse> responseCustomer = customerService.login(requestCustomer);
        if (responseCustomer.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(responseCustomer.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll() {
        customerService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
