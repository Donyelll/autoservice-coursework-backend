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
@Table(name = "service")
@JsonIdentityInfo(
        scope = ServiceTypeEntity.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ServiceTypeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "base_price")
    private int basePrice;

    @ManyToMany(mappedBy = "services")
    private List<MechanicEntity> mechanics;

    @OneToMany(mappedBy = "service")
    private List<OrderEntity> orders;
}
