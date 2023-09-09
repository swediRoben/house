package com.house.repository;

import com.house.entity.ExerciceEntity;
import com.house.entity.HouseHoldEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciceRepository extends JpaRepository<ExerciceEntity, Integer> {

    @Query("SELECT count(e) > 0 FROM ExerciceEntity e  WHERE e.libelle = :libelle")
    boolean existsByLibelle(@Param("libelle") String libelle);
@Query(value = "SELECT * FROM house h WHERE h.libelle =:libelle", nativeQuery = true)
List<ExerciceEntity> filterByExerciseId(@Param("libelle") String libelle);

  @Query("SELECT count(e) > 0 FROM ExerciceEntity e ")
  boolean countUser();


}
