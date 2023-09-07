package com.house.repository;

import com.house.entity.ExerciceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciceRepository extends JpaRepository<ExerciceEntity, Integer> {





}
