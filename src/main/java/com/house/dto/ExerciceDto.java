package com.house.dto;

import lombok.Data;

@Data
public class ExerciceDto {
    private Integer id;

    private String libelle;
    private String startDate;
    private String endDate;
}
