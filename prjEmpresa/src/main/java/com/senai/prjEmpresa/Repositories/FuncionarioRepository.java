package com.senai.prjEmpresa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.prjEmpresa.Entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}