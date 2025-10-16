package com.example.aula_validation.controller;

import com.example.aula_validation.dto.UsuarioRequestDTO;
import com.example.aula_validation.dto.UsuarioResponseDTO;
import com.example.aula_validation.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity <Map<String,Object>> saveUsuario (@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        usuarioService.saveUsuario(usuarioRequestDTO);

        return ResponseEntity.created(null).body(Map.of("message: ", "Usuário cadastrado!", "success", true));
    }

    @GetMapping
    public ResponseEntity <List<UsuarioResponseDTO>> listAllUsuario (){

        return ResponseEntity.ok()
                .body(usuarioService.listAllUsuario());
    }
}
