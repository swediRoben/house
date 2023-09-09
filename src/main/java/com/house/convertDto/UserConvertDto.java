package com.house.convertDto;

import com.house.dto.UserDto;
import com.house.entity.UserEntity;
import com.house.helper.DateHelper;

public class UserConvertDto {

private UserConvertDto(){};

public static UserConvertDto getInstance(){
return new UserConvertDto();
}

public UserEntity toEntity(UserDto dto){
UserEntity entity = new UserEntity();
entity.setId(dto.getId());
entity.setUsername(dto.getUsername());
entity.setEmail(dto.getEmail());
entity.setLastname(dto.getLastname());
entity.setPassword(dto.getPassword());
entity.setTel(dto.getTel());
entity.setSex(dto.getSex());
entity.setDateCreation(DateHelper.toDate(dto.getDateCreation()));
entity.setRoles(dto.getRoles());
return entity;
}

public UserDto toDto(UserEntity entity){
UserDto dto = new UserDto();
dto.setId(entity.getId());
dto.setUsername(entity.getUsername());
dto.setLastname(entity.getLastname());

// dto.setPrenom(entity.getPrenom());
dto.setEmail(entity.getEmail());
dto.setPassword(entity.getPassword());
dto.setTel(entity.getTel());
dto.setSex(entity.getSex());
dto.setRoles(entity.getRoles());

dto.setDateCreation(DateHelper.toText(entity.getDateCreation()));
return dto;
}
}
