package com.github.autoservicecourseworkbackend.repository;


import com.github.autoservicecourseworkbackend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByCustomer_Id(int id);

    List<OrderEntity> findAllByMechanic_Id(int id);

}
