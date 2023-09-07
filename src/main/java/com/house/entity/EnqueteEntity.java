package com.house.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "enquete")
public class EnqueteEntity  implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", length = 11)
private Integer id;
@Column(name = "id_user", length = 50)
private Integer idUser;

private Date dateCreation;
private String province;

private String commune;
private String zone;
private String territoire;
private Boolean constant;

@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
@NotFound(action = NotFoundAction.IGNORE)
@JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
private ExerciceEntity exercise;

}
