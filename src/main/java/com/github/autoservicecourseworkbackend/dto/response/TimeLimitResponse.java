package com.github.autoservicecourseworkbackend.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TimeLimitResponse {

    private int id;
    private int duration;
    private double priceCoef;

}
