package com.house.repository;

import com.house.entity.ExerciceEntity;
import com.house.entity.HouseHoldEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseHoldRepository extends JpaRepository<HouseHoldEntitty, Integer> {

@Query(value = "SELECT * FROM house h WHERE h.id_exercise =:idExercise", nativeQuery = true)
List<HouseHoldEntitty> filterByExerciseId(@Param("idExercise") Integer idExercise); 

@Query(value = "SELECT count(h) FROM HouseHoldEntitty h WHERE h.idExercise =?1") 
Integer countMenage(Integer idExercice);

@Query(value = "SELECT count(h) FROM HouseHoldEntitty h WHERE h.idExercise =?1 and childrenWithDisabilities=true") 
Integer nombreMenageHandicape(Integer idExercice);

@Query(value = "SELECT count(h) FROM HouseHoldEntitty h WHERE h.idExercise =?1 and childrenWithDisabilities=false") 
Integer nombreSansMenageHandicape(Integer idExercice);

//    @Query(value = "SELECT * FROM house h WHERE h.libelle =:libelle", nativeQuery = true)
//    List<ExerciceEntity> filterByExerciseId(@Param("libelle") String libelle);
//@Query("SELECT count(e) > 0 FROM ExerciceEntity e  WHERE e.id = :id")
//boolean existsByExercise(Integer id);

@Query("select SUM(h.combienPersonHandicapeEnfant) from  HouseHoldEntitty  h where h.idExercise=?1 ")
Integer nombreEnfantHandicape(Integer idExercice);

@Query("select SUM(h.combienPersonHandicapeJeunesse) from HouseHoldEntitty  h where h.idExercise=?1")
Integer nombreJeuneHandicape(Integer idExercice);

}
