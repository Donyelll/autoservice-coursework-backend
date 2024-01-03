package com.github.autoservicecourseworkbackend.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import com.github.autoservicecourseworkbackend.dto.request.RequestMechanic;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mechanic")
public class MechanicEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "mechanic_service",
            joinColumns = {
                    @JoinColumn(name = "mechanic_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "service_id")
            }
    )
    private List<ServiceTypeEntity> services;

    @OneToMany(mappedBy = "mechanic")
    private List<OrderEntity> orders;

    public MechanicEntity(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public static MechanicEntity create(RequestMechanic requestMechanic){
        return new MechanicEntity(requestMechanic.getName(),
                requestMechanic.getSurname(),
                requestMechanic.getLogin(),
                requestMechanic.getPassword());
    }

    public void update(RequestMechanic requestMechanic){
        this.name = requestMechanic.getName();
        this.surname = requestMechanic.getSurname();
        this.login = requestMechanic.getLogin();
        this.password = requestMechanic.getPassword();
    }

}
