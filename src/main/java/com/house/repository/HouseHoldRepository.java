package com.house.repository;

import com.house.entity.HouseHoldEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseHoldRepository extends JpaRepository<HouseHoldEntitty, Integer> {

@Query(value = "SELECT * FROM exercise h WHERE h.id_exercise =:idExercise", nativeQuery = true)
List<HouseHoldEntitty> filterByExerciseId(@Param("idExercise") Integer idExercise);
}
