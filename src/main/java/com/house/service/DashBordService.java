package com.house.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.dto.Rapport;
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

    public List<Rapport> menageheureux(Integer idExercice) {
        List<Integer> trimestre=listTrimestre(idExercice);
        List<Rapport> data=new ArrayList<>(); 

         for (int i = 0; i < trimestre.size(); i++) {
             Rapport rap=new Rapport();
              Map<String, Object> dataPourcentage=new HashMap<>(); 
            Integer nombreMenage =menageRepository.getTotal(idExercice,trimestre.get(i));
            double nombreJamais=menageRepository.getTotalMenageHeureType(idExercice,trimestre.get(i),1);  
            double nombreParfois=menageRepository.getTotalMenageHeureType(idExercice,trimestre.get(i),2);  
            double nombreSouvent=menageRepository.getTotalMenageHeureType(idExercice,trimestre.get(i),3); 
            double pourcentageJamais =(nombreJamais*100)/nombreMenage;
            double pourcentageParfois =(nombreParfois*100)/nombreMenage;
            double pourcentageSouvent =(nombreSouvent*100)/nombreMenage;

            dataPourcentage.put("Nombre", nombreMenage);
             dataPourcentage.put("Never", pourcentageJamais);
            dataPourcentage.put("Sometimes", pourcentageParfois);
            dataPourcentage.put("Often", pourcentageSouvent);

            rap.setQuarter(trimestre.get(i));
            rap.setResponses(dataPourcentage);
            data.add(rap);
     
        }
 
        return data;
    }

    public Map<String, Object> menagebyquestionnaire(Integer idExercice) {
        List<Integer> trimestre=listTrimestre(idExercice); 
        Map<String, Object> data=new HashMap<>(); 
        Integer total=0;
        List<Rapport> rapoList=new ArrayList<>(); 
         for (int i = 0; i < trimestre.size(); i++) {
             Rapport rap=new Rapport();
              Map<String, Object> dataNobre=new HashMap<>(); 
            Integer nombreMenage =menageRepository.getTotal(idExercice,trimestre.get(i));  
             total+=nombreMenage;
            dataNobre.put("Nombre", nombreMenage); 

            rap.setQuarter(trimestre.get(i));
            rap.setResponses(dataNobre);
         rapoList.add(rap);
           
        }
           
        data.put("total", total);  
        data.put("parTrimestre", rapoList);
        return data;
    }

    public List<Rapport> formation(Integer idExercice) {
         List<Integer> trimestre=listTrimestre(idExercice);
        List<Rapport> data=new ArrayList<>();  

         for (int i = 0; i < trimestre.size(); i++) {
             Rapport rap=new Rapport();
              Map<String, Object> dataPourcentage=new HashMap<>(); 
            Integer nombreMenage =menageRepository.getTotal(idExercice,trimestre.get(i));
            double nombreVeryUseful=menageRepository.getTotalEvaluationParticipantionAuxFormarmationType(idExercice,trimestre.get(i),1);  
            double nombreSomewhatUseful=menageRepository.getTotalEvaluationParticipantionAuxFormarmationType(idExercice,trimestre.get(i),2);  
            double nombreNotAllUseful=menageRepository.getTotalEvaluationParticipantionAuxFormarmationType(idExercice,trimestre.get(i),3); 
            double pourcentageVeryUseful =(nombreVeryUseful*100)/nombreMenage;
            double pourcentageSomewhatUseful =(nombreSomewhatUseful*100)/nombreMenage;
            double pourcentageNotAllUseful =(nombreNotAllUseful*100)/nombreMenage;

            dataPourcentage.put("Nombre", nombreMenage);
            dataPourcentage.put("VeryUseful", pourcentageVeryUseful);
            dataPourcentage.put("SomewhatUseful", pourcentageSomewhatUseful);
            dataPourcentage.put("NotAllUseful", pourcentageNotAllUseful);

            rap.setQuarter(trimestre.get(i));
            rap.setResponses(dataPourcentage);
            data.add(rap);
     
        }
 
        return data;
    }
    
}
