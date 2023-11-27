package com.senai.prjEmpresa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.prjEmpresa.Entities.Funcionario;
import com.senai.prjEmpresa.Services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "Funcionários", description = "API REST DE GERENCIAMENTO DE FUNCIONÁRIOS")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza funcionário por ID ")
	public ResponseEntity<Funcionario> findFuncionariobyId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.findFuncionarioById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation("Apresenta todos os funcionários")
	public ResponseEntity<List<Funcionario>> findAllFuncionarioscontrol() {
		List<Funcionario> funcionarios = funcionarioService.findAllFuncionario();
		return ResponseEntity.ok(funcionarios);
	}

	@PostMapping("/{id}")
	@Operation(summary = "Cadastra um Funcionário")
	public ResponseEntity<Funcionario> insertFuncionariosControl(@RequestBody @Valid Funcionario funcionario) {
		Funcionario novoFuncionario = funcionarioService.insertFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
	}

	@PutMapping("/id")
	@Operation(summary = "Altera um Funcionário")
	public ResponseEntity<Funcionario> updateFuncionarioControl(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
	    Funcionario mudafuncionario = funcionarioService.updateFuncionario(id, funcionario);
		if (mudafuncionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/id")
	@Operation(summary = "Excluí um Funcionário")
	public ResponseEntity<String> deleteFuncionarioControl(@PathVariable Long id) {
		boolean remover = funcionarioService.deleteFuncionario(id);
		if (remover) {
			return ResponseEntity.ok().body("Funcionário Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
