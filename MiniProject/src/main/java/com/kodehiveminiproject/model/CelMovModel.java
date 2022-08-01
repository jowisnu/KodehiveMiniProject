package com.kodehiveminiproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="T_CEL_MOV")

public class CelMovModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int idCel;
	private int idMov;
}
