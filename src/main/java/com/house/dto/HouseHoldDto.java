package com.house.dto;

import lombok.Data;

@Data
public class HouseHoldDto {
    private Integer id;
    private Integer idExercise;
    private Integer idTrimestreConstant;
    private String dateCreation;
    private Boolean questionnaire;

    private Integer householdStatus;
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
    private Integer HPVWomen;
    private ExerciceDto exercise;
}
