package com.github.autoservicecourseworkbackend.repository;

import com.github.autoservicecourseworkbackend.entity.TimeLimitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeLimitRepository extends JpaRepository<TimeLimitEntity, Integer> {


}
