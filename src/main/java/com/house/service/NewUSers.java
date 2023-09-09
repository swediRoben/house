package com.house.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.ExerciceEntity;
import com.house.entity.UserEntity;
import com.house.repository.ExerciceRepository;
import com.house.repository.UserRepository;

@Service
public class NewUSers {
   
     @Autowired
    private ExerciceRepository repository;

     @Autowired
     private UserRepository useRepository;

    public boolean verifyUserExist() {
        return repository.countUser();
    }

    public void createFestAdmin() {
        ExerciceEntity ex=new ExerciceEntity();
        ex.setLibelle("exercise 1");
        ex.setStartDate(new Date());
        ex.setEndDate(new Date());
        repository.save(ex);
   
        UserEntity user=new UserEntity(); 
        user.setEmail("admin@email.com");
        user.setUsername("admin");
        user.setTel("000000");
        user.setPassword("123");
        user.setSex("1");
        user.setRoles("admin");
        user.setLastname("admin");
        user.setDateCreation(new Date());
        useRepository.save(user);

    }
}
