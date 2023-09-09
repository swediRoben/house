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
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getIdUser() {
	return idUser;
}
public void setIdUser(Integer idUser) {
	this.idUser = idUser;
}
public String getDateCreation() {
	return dateCreation;
}
public void setDateCreation(String dateCreation) {
	this.dateCreation = dateCreation;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCommune() {
	return commune;
}
public void setCommune(String commune) {
	this.commune = commune;
}
public String getZone() {
	return zone;
}
public void setZone(String zone) {
	this.zone = zone;
}
public String getTerritoire() {
	return territoire;
}
public void setTerritoire(String territoire) {
	this.territoire = territoire;
}
public Boolean getConstant() {
	return constant;
}
public void setConstant(Boolean constant) {
	this.constant = constant;
}


}
