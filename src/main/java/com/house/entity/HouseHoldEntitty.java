package com.house.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "house")
public class HouseHoldEntitty implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Integer id;
    @Column(name = "id_exercise", length = 50)
    private Integer idExercise;
    @Column(name = "id_trimestre_constant")
    private Integer idTrimestreConstant;
    @Column(name = "date_debut")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dateCreation;
    @Column(name = "questionnaire")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "id_exercise", referencedColumnName = "id", insertable = false, updatable = false)
    private ExerciceEntity exercise;
}
