package com.example.atvd6.controller;

import com.example.atvd6.model.FuncionarioModel;
import com.example.atvd6.services.FuncionarioService;
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
    public List <FuncionarioModel> listAll (){
        return funcionarioService.listAll();
    }

    @PostMapping
    public ResponseEntity <Map<String,Object>> saveFuncionario (@RequestBody FuncionarioModel funcionario){
        funcionarioService.saveFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem: ", "Usuário Cadastrado!", "success", true));
    }

'    @PutMapping ("/{id}")
    public ResponseEntity <Map<String, Object>> updateFuncionario (@RequestBody FuncionarioModel funcionario, @PathVariable Long id){
        funcionarioService.updateFuncionario(funcionario, id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem: ", "Usuário Atualizado", "success", true));
    }'
    
    @DeleteMapping ("/{id}")
    public ResponseEntity <Map<String, Object>> deleteFuncionario (@PathVariable Long id){
        funcionarioService.deleteFuncionario(id);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem: ", "Usuário Deletado!", "success", true));

    }
}
