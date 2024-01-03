package com.github.autoservicecourseworkbackend.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class MechanicResponse {

    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private List<ServiceTypeResponse> services;
    private List<OrderResponse> orders;


}
