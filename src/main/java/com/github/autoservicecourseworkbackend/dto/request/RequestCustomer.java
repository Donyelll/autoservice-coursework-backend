package com.github.autoservicecourseworkbackend.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCustomer {

    private String name;
    private String surname;
    private String login;
    private String password;

}
