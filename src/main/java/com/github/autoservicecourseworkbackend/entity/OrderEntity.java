package com.github.autoservicecourseworkbackend.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service_order")
@JsonIdentityInfo(
        scope = OrderEntity.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private MechanicEntity mechanic;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceTypeEntity service;

    @ManyToOne
    @JoinColumn(name = "time_limit_id")
    private TimeLimitEntity timeLimit;

    @ManyToOne
    @JoinColumn(name = "materials_id")
    private MaterialsEntity materials;

    @Column(name = "total_price")
    private int totalPrice;

    public OrderEntity(CustomerEntity customer, MechanicEntity mechanic, ServiceTypeEntity service, TimeLimitEntity timeLimit, MaterialsEntity materials) {
        this.customer = customer;
        this.mechanic = mechanic;
        this.service = service;
        this.timeLimit = timeLimit;
        this.materials = materials;
        this.totalPrice = (int) Math.round(service.getBasePrice() * materials.getPriceCoef() * timeLimit.getPriceCoef());
    }


}
