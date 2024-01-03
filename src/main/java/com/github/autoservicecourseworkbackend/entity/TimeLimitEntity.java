package com.github.autoservicecourseworkbackend.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time_limit")
@JsonIdentityInfo(
        scope = TimeLimitEntity.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TimeLimitEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price_coef")
    private double priceCoef;

    @OneToMany(mappedBy = "timeLimit")
    private List<OrderEntity> orders;
}
