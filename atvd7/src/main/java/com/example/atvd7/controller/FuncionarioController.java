package com.example.atvd7.controller;

import com.example.atvd7.model.FuncionarioModel;
import com.example.atvd7.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping ("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List <FuncionarioModel> listAllFuncionario (){
        return funcionarioService.listAllFuncionario();

    }

    @PostMapping
    public ResponseEntity <Map<String, Object>> saveFuncionario (@RequestBody FuncionarioModel funcionario){
        funcionarioService.saveFuncionario(funcionario);
    return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message: ", "Funcionário cadastrado", "success", true));

    }

    @PutMapping ("/{id}")
    public ResponseEntity <Map<String, Object>> updateFuncionario (@RequestBody FuncionarioModel funcionario, @PathVariable Long id){
        funcionarioService.updateFuncionario(funcionario,id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message: ", "Funcionário atualizado!", "success", true));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Map<String, Object>> deleteFuncionario (@PathVariable Long id, @RequestBody FuncionarioModel funcionario){
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message: ", "Funcionário deletado!", "success", true));

    }

}
