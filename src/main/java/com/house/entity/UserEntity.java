package com.house.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
private static final long serialVersionUID = 1L;

//. nom, prenom, email, mot de passe

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", length = 11)
private Integer id;
@Column(name = "nom", length = 50)
private String nom;
@Column(name = "prenom")
private String prenom;
@Email
@Column(name = "email", length = 50)
private String email;
@Column(name = "password")
private String password;
@Column(name = "tel")
private String tel;
@Column(name = "sex")
private String sex;
@Column(name = "date_creation")
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private Date dateCreation;
}
