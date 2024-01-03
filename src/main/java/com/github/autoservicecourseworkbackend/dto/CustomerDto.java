package com.github.autoservicecourseworkbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private Integer id;
    private String name;
    private String surname;

}
