package com.example.atvd6.services;

import com.example.atvd6.exception.EmailException;
import com.example.atvd6.model.FuncionarioModel;
import com.example.atvd6.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List <FuncionarioModel> listAll (){
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel saveFuncionario (FuncionarioModel funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new EmailException("Email já cadastrado!");
        }
        return funcionarioRepository.save(funcionario);
    }

    public FuncionarioModel updateFuncionario (FuncionarioModel funcionario, Long id){
        if (!funcionarioRepository.existsById(id)){
            throw new RuntimeException("Funcionário não encontrado!");
        }

        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario (Long id){
        if (!funcionarioRepository.existsById(id)){
            throw new RuntimeException("Funcionário não encontrado!");
        }

        funcionarioRepository.deleteById(id);
    }
}
