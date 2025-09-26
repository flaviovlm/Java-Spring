package com.example.atvd4.controller;

import com.example.atvd4.model.Aluno;
import com.example.atvd4.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listAllCliente (){
        return alunoService.listAllAluno();
    }

    @PostMapping
    public ResponseEntity <Aluno> saveAluno (@RequestBody Aluno aluno){

        alunoService.saveAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PutMapping ("/{id}")
    public ResponseEntity <Aluno> updateAluno (@PathVariable UUID id, @RequestBody Aluno aluno){

        alunoService.updateAluno(id,aluno);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteAluno (@PathVariable UUID id){
        alunoService.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
