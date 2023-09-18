package com.house.dto;

import jakarta.persistence.Column;
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

    private String headOfHouseholdName;
    private Boolean childrenWithDisabilities;
    private Integer numberOfChildrenWithDisabilities;

	private Integer province;
	private Integer AireDeSante;
	private Integer ZoneDeSante;
	private String Avenue;
	private Integer NumeroDeTelephone;
	private Integer NumeroDeTelephone2;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdExercise() {
		return idExercise;
	}
	public void setIdExercise(Integer idExercise) {
		this.idExercise = idExercise;
	}
	public Integer getIdTrimestreConstant() {
		return idTrimestreConstant;
	}
	public void setIdTrimestreConstant(Integer idTrimestreConstant) {
		this.idTrimestreConstant = idTrimestreConstant;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Boolean getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Boolean questionnaire) {
		this.questionnaire = questionnaire;
	}
	public Integer getHouseholdStatus() {
		return householdStatus;
	}
	public void setHouseholdStatus(Integer householdStatus) {
		this.householdStatus = householdStatus;
	}
	public Integer getAgeOfHeadOfHouseHold() {
		return ageOfHeadOfHouseHold;
	}
	public void setAgeOfHeadOfHouseHold(Integer ageOfHeadOfHouseHold) {
		this.ageOfHeadOfHouseHold = ageOfHeadOfHouseHold;
	}
	public Integer getEducationLevelOfHeadOfHouseHold() {
		return educationLevelOfHeadOfHouseHold;
	}
	public void setEducationLevelOfHeadOfHouseHold(Integer educationLevelOfHeadOfHouseHold) {
		this.educationLevelOfHeadOfHouseHold = educationLevelOfHeadOfHouseHold;
	}
	public Integer getOccupationOfHeadOfHouseHold() {
		return occupationOfHeadOfHouseHold;
	}
	public void setOccupationOfHeadOfHouseHold(Integer occupationOfHeadOfHouseHold) {
		this.occupationOfHeadOfHouseHold = occupationOfHeadOfHouseHold;
	}
	public Integer getZeroToFiveYearsNumber() {
		return zeroToFiveYearsNumber;
	}
	public void setZeroToFiveYearsNumber(Integer zeroToFiveYearsNumber) {
		this.zeroToFiveYearsNumber = zeroToFiveYearsNumber;
	}
	public Integer getSixToTwelveYearsNumber() {
		return sixToTwelveYearsNumber;
	}
	public void setSixToTwelveYearsNumber(Integer sixToTwelveYearsNumber) {
		this.sixToTwelveYearsNumber = sixToTwelveYearsNumber;
	}
	public Integer getThirteenToEighteenYearsNumber() {
		return thirteenToEighteenYearsNumber;
	}
	public void setThirteenToEighteenYearsNumber(Integer thirteenToEighteenYearsNumber) {
		this.thirteenToEighteenYearsNumber = thirteenToEighteenYearsNumber;
	}
	public Integer getNineghteenToThirtyFiveYearsNumber() {
		return nineghteenToThirtyFiveYearsNumber;
	}
	public void setNineghteenToThirtyFiveYearsNumber(Integer nineghteenToThirtyFiveYearsNumber) {
		this.nineghteenToThirtyFiveYearsNumber = nineghteenToThirtyFiveYearsNumber;
	}
	public Integer getThirtySixToFiftyTwoYearsNumber() {
		return thirtySixToFiftyTwoYearsNumber;
	}
	public void setThirtySixToFiftyTwoYearsNumber(Integer thirtySixToFiftyTwoYearsNumber) {
		this.thirtySixToFiftyTwoYearsNumber = thirtySixToFiftyTwoYearsNumber;
	}
	public Integer getFiftyThreeYearsAndMoreNumber() {
		return FiftyThreeYearsAndMoreNumber;
	}
	public void setFiftyThreeYearsAndMoreNumber(Integer fiftyThreeYearsAndMoreNumber) {
		FiftyThreeYearsAndMoreNumber = fiftyThreeYearsAndMoreNumber;
	}
	public Integer getTotalMenInHousehold() {
		return totalMenInHousehold;
	}
	public void setTotalMenInHousehold(Integer totalMenInHousehold) {
		this.totalMenInHousehold = totalMenInHousehold;
	}
	public Integer getTotalWomenInHousehold() {
		return totalWomenInHousehold;
	}
	public void setTotalWomenInHousehold(Integer totalWomenInHousehold) {
		this.totalWomenInHousehold = totalWomenInHousehold;
	}
	public Integer getHPVMen() {
		return HPVMen;
	}
	public void setHPVMen(Integer hPVMen) {
		HPVMen = hPVMen;
	}
	public Integer getHPVWomen() {
		return HPVWomen;
	}
	public void setHPVWomen(Integer hPVWomen) {
		HPVWomen = hPVWomen;
	}
	public ExerciceDto getExercise() {
		return exercise;
	}
	public void setExercise(ExerciceDto exercise) {
		this.exercise = exercise;
	}
	public String getHeadOfHouseholdName() {
		return headOfHouseholdName;
	}
	public void setHeadOfHouseholdName(String headOfHouseholdName) {
		this.headOfHouseholdName = headOfHouseholdName;
	}
	public Boolean getChildrenWithDisabilities() {
		return childrenWithDisabilities;
	}
	public void setChildrenWithDisabilities(Boolean childrenWithDisabilities) {
		this.childrenWithDisabilities = childrenWithDisabilities;
	}
	public Integer getNumberOfChildrenWithDisabilities() {
		return numberOfChildrenWithDisabilities;
	}
	public void setNumberOfChildrenWithDisabilities(Integer numberOfChildrenWithDisabilities) {
		this.numberOfChildrenWithDisabilities = numberOfChildrenWithDisabilities;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getAireDeSante() {
		return AireDeSante;
	}

	public void setAireDeSante(Integer aireDeSante) {
		AireDeSante = aireDeSante;
	}

	public Integer getZoneDeSante() {
		return ZoneDeSante;
	}

	public void setZoneDeSante(Integer zoneDeSante) {
		ZoneDeSante = zoneDeSante;
	}

	public String getAvenue() {
		return Avenue;
	}

	public void setAvenue(String avenue) {
		Avenue = avenue;
	}

	public Integer getNumeroDeTelephone() {
		return NumeroDeTelephone;
	}

	public void setNumeroDeTelephone(Integer numeroDeTelephone) {
		NumeroDeTelephone = numeroDeTelephone;
	}

	public Integer getNumeroDeTelephone2() {
		return NumeroDeTelephone2;
	}

	public void setNumeroDeTelephone2(Integer numeroDeTelephone2) {
		NumeroDeTelephone2 = numeroDeTelephone2;
	}
}
