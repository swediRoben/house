package com.house.dto; 

import com.house.entity.ExerciceEntity;
import com.house.entity.HouseHoldEntitty;
import com.house.entity.UserEntity;
 
import lombok.Data;
@Data
public class HistoriqueDto {
    private Long id;
    private Integer idUser;
    private Integer idMenage;
    private Integer idTrimestre;
    private Integer idExercice;
    private String date;  
    private String type; 
    private String classe;
    private HouseHoldEntitty menage;  
    private UserEntity user;  
    private ExerciceEntity exercice; 
}
