package com.senai.prjEmpresa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.prjEmpresa.Entities.Funcionario;
import com.senai.prjEmpresa.Repositories.FuncionarioRepository;

@Service
public class FuncionarioService {


		private final FuncionarioRepository funcionarioRepository;

		@Autowired
		public FuncionarioService(FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository;
		}

		// preparando as buscas por id
		public Funcionario findFuncionarioById(Long id) {
			Optional<Funcionario> Funcionario = funcionarioRepository.findById(id);
			return Funcionario.orElse(null);
		}

		// preparando a busca geral
		public List<Funcionario> findAllFuncionario() {
			return funcionarioRepository.findAll();
		}


		public Funcionario insertFuncionario(Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}

	
		public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
			Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
			if (funcionarioOptional.isPresent()) {
				Funcionario funcionarioExistente = funcionarioOptional.get();
				funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
				funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
				funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
				return funcionarioRepository.save(funcionarioExistente);
			} else {
				return null;
			}
		}

		public boolean deleteFuncionario(Long id) {
			Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
			if (funcionarioExistente.isPresent()) {
				funcionarioRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		}

	}

