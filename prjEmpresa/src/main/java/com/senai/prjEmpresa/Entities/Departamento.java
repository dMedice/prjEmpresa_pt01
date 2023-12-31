package com.senai.prjEmpresa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Departamento")
public class Departamento {

   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long depcodigo;
   
   @NotNull
   @NotBlank
	private String depnome;
   

}

