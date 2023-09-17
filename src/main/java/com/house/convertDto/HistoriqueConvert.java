package com.house.convertDto;

import com.house.dto.EnqueteDto;
import com.house.dto.ExerciceDto;
import com.house.dto.HistoriqueDto;
import com.house.entity.EnqueteEntity;
import com.house.entity.ExerciceEntity;
import com.house.entity.HistoriqueEntity;
import com.house.helper.DateHelper;

import java.text.ParseException;

public class HistoriqueConvert {
/*private Integer id;
private Integer idUser;
private String dateCreation;
private String province;
private String commune;
private String zone;
private String territoire;
private Boolean constant;*/

private HistoriqueConvert(){};

public static HistoriqueConvert getInstance(){
return new HistoriqueConvert();
}

public HistoriqueEntity toEntity(HistoriqueDto dto) throws ParseException {
HistoriqueEntity entity = new HistoriqueEntity();
entity.setId(dto.getId());
entity.setIdUser(dto.getIdUser());

entity.setIdMenage(dto.getIdMenage());
entity.setIdExercice(dto.getIdExercice());
entity.setIdTrimestre(dto.getIdTrimestre());
entity.setDate(DateHelper.toDate(dto.getDate()));

return entity;
}

public HistoriqueDto toDto(HistoriqueEntity entity){
HistoriqueDto dto = new HistoriqueDto();
 dto.setId(entity.getId());
dto.setIdUser(entity.getIdUser());
dto.setIdMenage(entity.getIdMenage());
dto.setIdExercice(entity.getIdExercice());
dto.setIdTrimestre(entity.getIdTrimestre());
dto.setExercice(entity.getExerciceEntity());
dto.setUser(entity.getUserEntity());
dto.setMenage(entity.getMenage());
dto.setType(entity.getType());
dto.setClasse(entity.getClasse());

dto.setDate(DateHelper.toText(entity.getDate()));
return dto;
}

}
