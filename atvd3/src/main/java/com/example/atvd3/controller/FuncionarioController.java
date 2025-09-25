package com.example.atvd3.controller;

import com.example.atvd3.model.Funcionario;
import com.example.atvd3.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List <Funcionario> listAll (){
        return funcionarioService.lisAll();
    }

    @PostMapping
    public ResponseEntity <Funcionario> save (@RequestBody Funcionario funcionario){
        funcionarioService.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }
}
