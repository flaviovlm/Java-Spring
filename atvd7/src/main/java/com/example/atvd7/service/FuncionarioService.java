package com.example.atvd7.service;

import java.util.List;

import com.example.atvd7.exception.EmailException;
import com.example.atvd7.exception.MatriculaException;
import com.example.atvd7.model.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atvd7.controller.FuncionarioController;
import com.example.atvd7.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> listAllFuncionario (){
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel saveFuncionario (FuncionarioModel funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new EmailException("Email já cadastrado, tente novamente!");
        }else if (funcionarioRepository.findByMatricula(funcionario.getMatricula()).isPresent()){
            throw new MatriculaException("Essa matricula já esta sendo utilizada!");''
        }

        return funcionarioRepository.save(funcionario);
    }
    public FuncionarioModel updateFuncionario (FuncionarioModel funcionario, Long id){
        if (!funcionarioRepository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado!");
        }

        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario (Long id){
        if (!funcionarioRepository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado!");

        }

        funcionarioRepository.deleteById(id);
    }
}
