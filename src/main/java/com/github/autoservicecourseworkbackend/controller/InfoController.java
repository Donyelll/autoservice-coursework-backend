package com.github.autoservicecourseworkbackend.controller;


import com.github.autoservicecourseworkbackend.dto.response.InfoResponse;
import com.github.autoservicecourseworkbackend.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/info/")
@RequiredArgsConstructor
public class InfoController {

    private static final String APPLICATION_INFO = "Версия приложения: 0.0.1\nАвтор приложения: Жинко Даниил 113871";

    @GetMapping
    public ResponseEntity<InfoResponse> getAll() {
        return ResponseEntity.ok(new InfoResponse(APPLICATION_INFO));
    }

}
