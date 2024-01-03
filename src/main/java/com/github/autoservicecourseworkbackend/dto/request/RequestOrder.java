package com.github.autoservicecourseworkbackend.dto.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RequestOrder {

    private Integer customerId;
    private Integer mechanicId;
    private Integer serviceId;
    private Integer timeLimitId;
    private Integer materialsId;

}
