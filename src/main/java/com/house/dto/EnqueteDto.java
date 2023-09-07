package com.house.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EnqueteDto {
private Integer id;
private Integer idUser;
private String dateCreation;
private String province;
private String commune;
private String zone;
private String territoire;
private Boolean constant;
}
