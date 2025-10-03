package com.example.atvd5.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atvd5.model.UsuarioModel;
import com.example.atvd5.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List <UsuarioModel> listAll (){
        return usuarioService.listAll();
    }
    
    @PostMapping
    public ResponseEntity <Map<String, Object>> saveUsuario (@RequestBody UsuarioModel usuario) {
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadastrado Com Sucesso", "sucess: ", true));

    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Object>> updateUsuario (@PathVariable Long id, @RequestBody UsuarioModel usuario) {

        usuarioService.updateUsuario(usuario, id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem: ", "Usuário atualizado", "sucess: ", true));
       
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUsuario (@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Usuário deletado!", "sucess: ", true));

    }
    
}
