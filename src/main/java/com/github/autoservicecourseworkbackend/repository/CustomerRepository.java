package com.github.autoservicecourseworkbackend.repository;

import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

     Optional<CustomerEntity> findFirstById(int id);

     List<CustomerEntity> findAllByOrderByNameAsc();

     List<CustomerEntity> findAllByOrderByNameDesc();

     Optional<CustomerEntity> findFirstByLoginAndPassword(String login, String password);

}
