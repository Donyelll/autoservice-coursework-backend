package com.github.autoservicecourseworkbackend.repository;


import com.github.autoservicecourseworkbackend.entity.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Integer> {



}
