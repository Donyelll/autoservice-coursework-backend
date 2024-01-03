package com.github.autoservicecourseworkbackend.controller;


import com.github.autoservicecourseworkbackend.dto.response.MaterialsResponse;
import com.github.autoservicecourseworkbackend.dto.response.MechanicResponse;
import com.github.autoservicecourseworkbackend.dto.response.ServiceTypeResponse;
import com.github.autoservicecourseworkbackend.service.MaterialsService;
import com.github.autoservicecourseworkbackend.service.MechanicService;
import com.github.autoservicecourseworkbackend.service.ServiceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services/")
@RequiredArgsConstructor
public class ServiceTypeController {

    private final ServiceTypeService serviceTypeService;
    private final MechanicService mechanicService;

    @GetMapping
    public ResponseEntity<List<ServiceTypeResponse>> getAll() {
        return ResponseEntity.ok(serviceTypeService.getAll());
    }

    @GetMapping("{id}/mechanics")
    public ResponseEntity<List<MechanicResponse>> getAllMechanics(@PathVariable Integer id){
        return ResponseEntity.ok(mechanicService.getAllMechanicsByServiceId(id));
    }

}
