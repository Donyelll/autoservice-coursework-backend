package com.github.autoservicecourseworkbackend.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
public class ServiceTypeResponse {

    private int id;
    private String name;
    private int basePrice;

}
