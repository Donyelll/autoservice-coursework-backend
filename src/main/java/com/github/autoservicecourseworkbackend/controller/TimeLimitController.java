package com.github.autoservicecourseworkbackend.controller;

import com.github.autoservicecourseworkbackend.dto.response.ServiceTypeResponse;
import com.github.autoservicecourseworkbackend.dto.response.TimeLimitResponse;
import com.github.autoservicecourseworkbackend.service.ServiceTypeService;
import com.github.autoservicecourseworkbackend.service.TimeLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/time/")
@RequiredArgsConstructor
public class TimeLimitController {

    private final TimeLimitService timeLimitService;

    @GetMapping
    public ResponseEntity<List<TimeLimitResponse>> getAll() {
        return ResponseEntity.ok(timeLimitService.getAll());
    }

}
