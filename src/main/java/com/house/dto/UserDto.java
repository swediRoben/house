package com.house.dto;

import lombok.Data;

@Data
public class UserDto {
private Integer id;
private String nom;
private String prenom;
private String email;
private String password;
private String tel;
private String sex;
private String dateCreation;
}
