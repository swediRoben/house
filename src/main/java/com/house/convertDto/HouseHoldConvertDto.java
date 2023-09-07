package com.house.convertDto;

import com.house.dto.HouseHoldDto;
import com.house.entity.HouseHoldEntitty;
import com.house.helper.DateHelper;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class HouseHoldConvertDto {
    private HouseHoldConvertDto(){};

    public static HouseHoldConvertDto getInstance(){
        return new HouseHoldConvertDto();
    }

    public HouseHoldEntitty toEntity(HouseHoldDto dto) throws ParseException {
        HouseHoldEntitty entity = new HouseHoldEntitty();
        if (dto.getExercise() != null) {
            entity.setIdExercise(dto.getExercise().getId());
        }
        entity.setId(dto.getId());
        entity.setIdExercise(dto.getIdExercise());
        entity.setQuestionnaire(dto.getQuestionnaire());
        entity.setDateCreation(DateHelper.toDate(dto.getDateCreation()));
        entity.setIdTrimestreConstant(dto.getIdTrimestreConstant());

        entity.setHouseholdStatus(dto.getHouseholdStatus());
        entity.setAgeOfHeadOfHouseHold(dto.getAgeOfHeadOfHouseHold());
        entity.setEducationLevelOfHeadOfHouseHold(dto.getEducationLevelOfHeadOfHouseHold());
        entity.setOccupationOfHeadOfHouseHold(dto.getOccupationOfHeadOfHouseHold());
        entity.setZeroToFiveYearsNumber(dto.getZeroToFiveYearsNumber());
        entity.setSixToTwelveYearsNumber(dto.getSixToTwelveYearsNumber());
        entity.setThirteenToEighteenYearsNumber(dto.getThirteenToEighteenYearsNumber());

        entity.setNineghteenToThirtyFiveYearsNumber(dto.getNineghteenToThirtyFiveYearsNumber());
        entity.setThirtySixToFiftyTwoYearsNumber(dto.getThirtySixToFiftyTwoYearsNumber());

        entity.setFiftyThreeYearsAndMoreNumber(dto.getFiftyThreeYearsAndMoreNumber());
        entity.setTotalMenInHousehold(dto.getTotalMenInHousehold());
        entity.setTotalWomenInHousehold(dto.getTotalWomenInHousehold());
        entity.setHPVMen(dto.getHPVMen());
        entity.setHPVWomen(dto.getHPVWomen());
/*private Integer householdStatus;
    private Integer   ageOfHeadOfHouseHold;
    private Integer        educationLevelOfHeadOfHouseHold;
    private Integer    occupationOfHeadOfHouseHold;
    private Integer  zeroToFiveYearsNumber;
    private Integer sixToTwelveYearsNumber;
    private Integer  thirteenToEighteenYearsNumber;
    private Integer nineghteenToThirtyFiveYearsNumber;
    private Integer thirtySixToFiftyTwoYearsNumber;
    private Integer FiftyThreeYearsAndMoreNumber;
    private Integer  totalMenInHousehold;
    private Integer totalWomenInHousehold;
    private Integer HPVMen;
    private Integer HPVWomen;*/
        return entity;
    }

    public HouseHoldDto toDto(HouseHoldEntitty entity){
        HouseHoldDto dto = new HouseHoldDto();

        if (entity.getExercise() != null){
            dto.setExercise(ExerciceConvertDto.getInstance().toDto(entity.getExercise()));
        }
        dto.setId(entity.getId());
        dto.setQuestionnaire(entity.getQuestionnaire());
        dto.setDateCreation(DateHelper.toText(entity.getDateCreation()));
        dto.setIdExercise(entity.getIdExercise());
        dto.setIdTrimestreConstant(entity.getIdTrimestreConstant());

        dto.setNineghteenToThirtyFiveYearsNumber(entity.getNineghteenToThirtyFiveYearsNumber());
        dto.setThirtySixToFiftyTwoYearsNumber(entity.getThirtySixToFiftyTwoYearsNumber());

        dto.setHouseholdStatus(entity.getHouseholdStatus());
        dto.setAgeOfHeadOfHouseHold(entity.getAgeOfHeadOfHouseHold());
        dto.setEducationLevelOfHeadOfHouseHold(entity.getEducationLevelOfHeadOfHouseHold());
        dto.setOccupationOfHeadOfHouseHold(entity.getOccupationOfHeadOfHouseHold());
        dto.setZeroToFiveYearsNumber(entity.getZeroToFiveYearsNumber());
        dto.setSixToTwelveYearsNumber(entity.getSixToTwelveYearsNumber());
        dto.setThirteenToEighteenYearsNumber(entity.getThirteenToEighteenYearsNumber());
        dto.setFiftyThreeYearsAndMoreNumber(entity.getFiftyThreeYearsAndMoreNumber());
        dto.setTotalMenInHousehold(entity.getTotalMenInHousehold());
        dto.setTotalWomenInHousehold(entity.getTotalWomenInHousehold());
        dto.setHPVMen(entity.getHPVMen());
        dto.setHPVWomen(entity.getHPVWomen());
        return dto;
    }
}
