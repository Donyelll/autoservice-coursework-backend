package com.github.autoservicecourseworkbackend.dto.response;

import com.github.autoservicecourseworkbackend.dto.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class OrderResponse {

    private int id;
    private CustomerDto customer;
    private MechanicDto mechanic;
    private ServiceTypeResponse service;
    private TimeLimitResponse timeLimit;
    private MaterialsResponse materials;
    private int totalPrice;

}
