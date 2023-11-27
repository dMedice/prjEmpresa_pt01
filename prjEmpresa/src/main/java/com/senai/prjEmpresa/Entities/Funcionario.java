package com.senai.prjEmpresa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Funcionário")
public class Funcionario {

	
	   
	   @NotNull
	   @NotBlank
		private String funnome;
	   
	  
	   @NotNull
	   @NotBlank
		private Long funsalario;
	   
	   @NotBlank
	   @NotNull
	   @DateTimeFormat(pattern = "dd/MM/yyyy")
	   private LocalDate funnascimento;

	}

