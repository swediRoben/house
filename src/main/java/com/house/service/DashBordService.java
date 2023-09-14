package com.house.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.repository.HouseHoldRepository;
import com.house.repository.QuestionMenageRepository;

@Service
public class DashBordService {

    @Autowired
    private HouseHoldRepository repository;

    @Autowired
    private QuestionMenageRepository menageRepository;

        public List<Integer> listTrimestre(Integer idExercice)
    {
         List<Integer> trimestre=new ArrayList<>();
         if (idExercice!=null) {
            trimestre=menageRepository.getTrimestreByExercice(idExercice);
         } 
        return trimestre;

    } 
    
    public Map<String, Object> countMenage(Integer idExercice) {
        Map<String, Object> data=new HashMap<>();
        Integer nombreMenage=repository.countMenage(idExercice);
        Integer nombreMenageHandicape=repository.nombreMenageHandicape(idExercice);
        Integer nombreMenageSansHandicape=repository.nombreSansMenageHandicape(idExercice);

        data.put("nombreMenage", nombreMenage);
        data.put("nombreMenageHandicape", nombreMenageHandicape);
        data.put("nombreMenageSansHandicape", nombreMenageSansHandicape);

        return data;
    } 

    public Map<String, Object> nombreHandicape(Integer idExercice) {
        Map<String, Object> data=new HashMap<>();  
        List<Integer> trimestre=listTrimestre(idExercice);
         List<Integer> nombreEnfantHandicape=listTrimestre(idExercice);
          List<Integer> nombreJeuneHandicape=listTrimestre(idExercice);
        Integer totalEnfant=0;
        Integer totalJeune=0;
        for (int i = 0; i < trimestre.size(); i++) {
            Integer nombreEnf =menageRepository.nombreEnfantHandicape(idExercice,trimestre.get(i));
            Integer nombreJeun=menageRepository.nombreJeuneHandicape(idExercice,trimestre.get(i));
          nombreEnfantHandicape.add(menageRepository.nombreEnfantHandicape(idExercice,trimestre.get(i)));
          nombreJeuneHandicape.add(menageRepository.nombreJeuneHandicape(idExercice,trimestre.get(i)));
        totalEnfant=totalEnfant+nombreEnf;
        totalJeune=totalJeune+nombreJeun;
     
        }

        data.put("nombreEnfantHandicapeTrimeste", nombreEnfantHandicape);
        data.put("nombreJeuneHandicapeTrimeste", nombreEnfantHandicape);
        data.put("totalEnfantHandicape", totalEnfant);
        data.put("totalJeuneHandicape", totalJeune);

        return data;
    }
    
}
