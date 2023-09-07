package com.house.controller;

import com.house.dto.ExerciceDto;
import com.house.dto.UserDto;
import com.house.entity.ExerciceEntity;
import com.house.entity.UserEntity;
import com.house.helper.MessageHelper;
import com.house.helper.ResponseHelper;
import com.house.repository.ExerciceRepository;
import com.house.repository.UserRepository;
import com.house.service.ExerciceService;
import com.house.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class UserController {
@Autowired
private UserService exerciceService;
@Autowired
private UserRepository repository;

@RequestMapping(value = "/getAll/a", method = RequestMethod.GET)
public ResponseEntity<?> getAll() {

List<UserDto> dtos = exerciceService.getAll();
if (dtos != null) {
return new ResponseEntity<>(new ResponseHelper(null, dtos, true), HttpStatus.OK);
}
return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.NO_CONTENT);
}

@GetMapping("/")
public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
        @RequestParam(required = false) String title,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id,desc") String[] sort) {

try {
List<Sort.Order> orders = new ArrayList<Sort.Order>();

if (sort[0].contains(",")) {

for (String sortOrder : sort) {
String[] _sort = sortOrder.split(",");
orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
}
} else {
orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
}

List<UserEntity> entities = new ArrayList<UserEntity>();
Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

Page<UserEntity> entityPage = null;
if (title == null)
entityPage = repository.findAll(pagingSort);


entities = entityPage.getContent();

Map<String, Object> response = new HashMap<>();
response.put("users", entities);
response.put("currentPage", entityPage.getNumber());
response.put("totalItems", entityPage.getTotalElements());
response.put("totalPages", entityPage.getTotalPages());

return new ResponseEntity<>(response, HttpStatus.OK);
} catch (Exception e) {
return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}


@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
UserDto dto = exerciceService.getByIdm(id);

if (dto != null) {
return new ResponseEntity<>(new ResponseHelper(null, dto, true), HttpStatus.OK);
}
return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.NO_CONTENT);
}

@PostMapping("/")
public ResponseEntity<?> create(@RequestBody UserDto dto) {
UserDto userDto = exerciceService.createm(dto);

if (userDto != null) {
return new ResponseEntity<>(new ResponseHelper(null, userDto, true), HttpStatus.OK);
}
return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.NO_CONTENT);
}

@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
public ResponseEntity<?> update(@RequestBody UserDto dto,
                                @PathVariable(name = "id", required = true) Integer id) {
UserDto userDto = exerciceService.updatem(id, dto);
if (userDto != null) {
return new ResponseEntity<>(new ResponseHelper(null, userDto, true), HttpStatus.OK);
}
return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.OK);
}

@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id) {
boolean dto = exerciceService.deleteByIdm(id);

if (dto) {
return new ResponseEntity<>(new ResponseHelper(null, dto, true), HttpStatus.OK);
}
return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.NO_CONTENT);
}

private Sort.Direction getSortDirection(String direction) {
if (direction.equals("asc")) {
return Sort.Direction.ASC;
} else if (direction.equals("desc")) {
return Sort.Direction.DESC;
}

return Sort.Direction.ASC;
}


}
