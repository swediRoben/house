package com.house.controller;

import com.house.convertDto.UserConvertDto;
import com.house.dto.UserDto;
import com.house.entity.UserEntity;
import com.house.helper.MessageHelper;
import com.house.helper.ResponseHelper;
import com.house.repository.UserRepository;
import com.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repository;

    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/getAll/a", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {

        List<UserDto> dtos = userService.getAll();
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
        UserDto dto = userService.getByIdm(id);

        if (dto != null) {
            return new ResponseEntity<>(new ResponseHelper(null, dto, true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserDto dto) {

        if (repository.existsByUsername(dto.getUsername()))
            return new ResponseEntity<>(new ResponseHelper(MessageHelper.dataExist("username"), false),
                    HttpStatus.BAD_REQUEST);

        UserDto userDto = userService.create1(dto);

        if (userDto != null) {
            return new ResponseEntity<>(new ResponseHelper("sucess", true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody UserDto dto,
                                    @PathVariable(name = "id", required = true) Integer id) {
        UserDto userDto = userService.updatem(id, dto);
        if (userDto != null) {
            return new ResponseEntity<>(new ResponseHelper("sucess", true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id) {
        boolean dto = userService.deleteByIdm(id);

        if (dto) {
            return new ResponseEntity<>(new ResponseHelper("sucess", true), HttpStatus.OK);
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




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto dto) {

        UserEntity user = repository.findByUsername(dto.getUsername());
        if (user == null)
            return new ResponseEntity<>(new ResponseHelper("User does not exist", true), HttpStatus.BAD_REQUEST);
            UserDto dto1 = UserConvertDto.getInstance().toDto(user);

            if (dto1 == null) {
                return new ResponseEntity<>(new ResponseHelper("Invalid username or password", true), HttpStatus.BAD_REQUEST);

            }

            if (!user.getPassword().equals(dto.getPassword())) {
                return new ResponseEntity<>(new ResponseHelper("Invalid username or password", true), HttpStatus.BAD_REQUEST);
            }
            if (dto.getUsername().equals(dto1.getUsername()) && dto.getPassword().equals(dto1.getPassword()))
                return new ResponseEntity<>(new ResponseHelper("success", true), HttpStatus.OK);

            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
