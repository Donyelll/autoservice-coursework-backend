package com.github.autoservicecourseworkbackend.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.autoservicecourseworkbackend.dto.request.RequestCustomer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {

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

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

    public CustomerEntity(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public static CustomerEntity create(RequestCustomer requestCustomer){
        return new CustomerEntity(requestCustomer.getName(),
                requestCustomer.getSurname(),
                requestCustomer.getLogin(),
                requestCustomer.getPassword());
    }

    public void update(RequestCustomer requestCustomer){
        this.name = requestCustomer.getName();
        this.surname = requestCustomer.getSurname();
        this.login = requestCustomer.getLogin();
        this.password = requestCustomer.getPassword();
    }

}
