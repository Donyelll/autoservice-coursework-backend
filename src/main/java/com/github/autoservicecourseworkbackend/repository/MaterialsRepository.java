package com.github.autoservicecourseworkbackend.repository;


import com.github.autoservicecourseworkbackend.entity.MaterialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialsRepository extends JpaRepository<MaterialsEntity,Integer> {


}
