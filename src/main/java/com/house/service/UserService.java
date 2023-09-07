package com.house.service;

import com.house.convertDto.ExerciceConvertDto;
import com.house.convertDto.UserConvertDto;
import com.house.dto.ExerciceDto;
import com.house.dto.UserDto;
import com.house.entity.ExerciceEntity;
import com.house.entity.UserEntity;
import com.house.helper.PagingAndSortingHelper;
import com.house.repository.ExerciceRepository;
import com.house.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

@Autowired
private UserRepository repository;




public List<UserDto> getAll() {

List<UserEntity> entities = repository.findAll();
List<UserDto> dtos = new ArrayList<>();

try {
for (UserEntity entity : entities) {
UserDto dto = UserConvertDto.getInstance().toDto(entity);
dtos.add(dto);

}
} catch (Exception e) {
System.out.println(e.getMessage());
}
return dtos;
}




//ImoProformaImmobilisationService
public UserDto getByIdm(Integer id) {

UserEntity entity = null;
UserDto dto = null;

try {
entity = repository.getById(id);
dto = UserConvertDto.getInstance().toDto(entity);
} catch (Exception e) {
System.out.println(e.getMessage());
dto = null;
}
return dto;
}



public UserDto createm(UserDto userDto) {
UserDto dto = null;

try {
UserEntity imoEntity = UserConvertDto.getInstance()
        .toEntity(userDto);
//            imoEntity.setDateCreation(DateHelper.now());
UserEntity fromBd = repository.save(imoEntity);

dto = UserConvertDto.getInstance().toDto(fromBd);

} catch (Exception e) {
System.out.println(e.getMessage());
dto = null;
}
return userDto;
}

public boolean deleteByIdm(Integer id) {
boolean result = false;
try {
UserDto userDto = getByIdm(id);
if (userDto != null) {
repository.deleteById(id);
result = true;
}
} catch (Exception e) {
System.out.println(e.getMessage());
result = false;
}
return result;

}

public UserDto updatem(int id, UserDto dto) {
UserEntity entity = null;

try {
entity = repository.getById(id);
dto.setId(entity.getId());
entity = UserConvertDto.getInstance().toEntity(dto);
UserEntity updated = repository.save(entity);
dto = UserConvertDto.getInstance().toDto(updated);
} catch (Exception e) {
dto = null;
System.out.println(e.getMessage());
}
return dto;
}

}
