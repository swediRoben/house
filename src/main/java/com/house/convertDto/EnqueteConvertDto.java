package com.house.convertDto;

import com.house.dto.EnqueteDto;
import com.house.dto.ExerciceDto;
import com.house.entity.EnqueteEntity;
import com.house.entity.ExerciceEntity;
import com.house.helper.DateHelper;

import java.text.ParseException;

public class EnqueteConvertDto {
/*private Integer id;
private Integer idUser;
private String dateCreation;
private String province;
private String commune;
private String zone;
private String territoire;
private Boolean constant;*/

private EnqueteConvertDto(){};

public static EnqueteConvertDto getInstance(){
return new EnqueteConvertDto();
}

public EnqueteEntity toEntity(EnqueteDto dto) throws ParseException {
EnqueteEntity entity = new EnqueteEntity();
entity.setId(dto.getId());
entity.setDateCreation(DateHelper.toDate(dto.getDateCreation()));
entity.setProvince(dto.getProvince());
entity.setCommune(dto.getCommune());
entity.setZone(dto.getZone());
entity.setTerritoire(dto.getTerritoire());
entity.setConstant(dto.getConstant());
entity.setIdUser(dto.getIdUser());

return entity;
}

public EnqueteDto toDto(EnqueteEntity entity){
EnqueteDto dto = new EnqueteDto();

dto.setId(entity.getId());
dto.setDateCreation(DateHelper.toText(entity.getDateCreation()));
dto.setProvince(entity.getProvince());
dto.setCommune(entity.getCommune());
dto.setZone(entity.getZone());
dto.setTerritoire(entity.getTerritoire());
dto.setConstant(entity.getConstant());
dto.setIdUser(entity.getIdUser());

return dto;
}

}
