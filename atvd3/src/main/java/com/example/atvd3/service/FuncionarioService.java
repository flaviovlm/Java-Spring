package com.example.atvd3.service;

import com.example.atvd3.model.Funcionario;
import com.example.atvd3.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List <Funcionario> lisAll (){
        return funcionarioRepository.findAll();
    }

    public void save (Funcionario funcionario){
        if (funcionarioRepository.findByTelefone(funcionario.getTelefone()).isPresent()){
            throw new RuntimeException("Funcinário já cadastrado");
        }
        funcionarioRepository.save(funcionario);
    }
}
