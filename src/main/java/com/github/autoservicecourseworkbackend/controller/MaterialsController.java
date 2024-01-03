package com.github.autoservicecourseworkbackend.controller;

import com.github.autoservicecourseworkbackend.dto.response.CustomerResponse;
import com.github.autoservicecourseworkbackend.dto.response.MaterialsResponse;
import com.github.autoservicecourseworkbackend.service.MaterialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materials/")
@RequiredArgsConstructor
public class MaterialsController {

    private final MaterialsService materialsService;

    @GetMapping
    public ResponseEntity<List<MaterialsResponse>> getAll() {
        return ResponseEntity.ok(materialsService.getAll());
    }

}
