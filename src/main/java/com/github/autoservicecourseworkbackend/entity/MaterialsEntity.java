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
@Table(name = "materials")
@JsonIdentityInfo(
        scope = MaterialsEntity.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class MaterialsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_coef")
    private double priceCoef;

    @OneToMany(mappedBy = "materials")
    private List<OrderEntity> orders;
}
