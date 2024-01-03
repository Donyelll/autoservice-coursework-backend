package com.github.autoservicecourseworkbackend.repository;

import com.github.autoservicecourseworkbackend.entity.CustomerEntity;
import com.github.autoservicecourseworkbackend.entity.MechanicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<MechanicEntity, Integer> {

    List<MechanicEntity> findAllByServices_IdIs(Integer id);

    Optional<MechanicEntity> findFirstByLoginAndPassword(String login, String password);

}
