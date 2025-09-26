package com.example.atvd4.service;

import com.example.atvd4.model.Aluno;
import com.example.atvd4.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List <Aluno> listAllAluno(){
        return alunoRepository.findAll();
    }

    public void saveAluno (Aluno aluno){
        if (alunoRepository.findByTelefone(aluno.getTelefone()).isPresent()){
            throw new RuntimeException("Aluno já cadastrado!");
        }

        alunoRepository.save(aluno);
    }

    public Aluno updateAluno (UUID id, Aluno aluno){
        if (!alunoRepository.existsById(id)){
            throw new RuntimeException("Aluno não encontrado!");
        }

        aluno.setId(id);

        return alunoRepository.save(aluno);
    }

    public void deleteAluno (UUID id){
        if (!alunoRepository.existsById(id)){
            throw new RuntimeException("Aluno não encontrado!");
        }

        alunoRepository.deleteById(id);
    }

}
