package com.house.controller;
 
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.house.helper.MessageHelper;
import com.house.helper.ResponseHelper;
import com.house.service.DashBordService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dashBord")
public class DashbordControler {
   
    @Autowired
    private DashBordService service;
    @GetMapping(value = "/menage")
     public ResponseEntity<Object> countMenage( 
                                @RequestHeader(name = "Accept-Language", required = false) String localeString,    
                                 @RequestParam(required = false) Integer idExercice) { 
  
        Map<String, Object> data = service.countMenage(idExercice);

        if (data.size() > 0) {
            return new ResponseEntity<>(new ResponseHelper("succes",data, true), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseHelper("not found", false), HttpStatus.NOT_FOUND);
        }

 } 

   @GetMapping(value = "/nombreHandicape")
     public ResponseEntity<Object> nombreJeuneHandicape( 
                                @RequestHeader(name = "Accept-Language", required = false) String localeString,    
                                 @RequestParam(required = false) Integer idExercice) { 
  
        Map<String, Object> data = service.nombreHandicape(idExercice);

        if (data.size() > 0) {
            return new ResponseEntity<>(new ResponseHelper("succes", data, true), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseHelper("not found", false), HttpStatus.NOT_FOUND);
        }

 } 
}
