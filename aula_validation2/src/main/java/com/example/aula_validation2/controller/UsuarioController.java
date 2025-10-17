package com.example.aula_validation2.controller;

import com.example.aula_validation2.dto.UsuarioRequestDTO;
import com.example.aula_validation2.dto.UsuarioResponseDTO;
import com.example.aula_validation2.model.UsuarioModel;
import com.example.aula_validation2.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity <Map<String, Object>> saveUsuario (@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        usuarioService.saveUsuario(usuarioRequestDTO);
        return ResponseEntity.created(null).body(Map.of("message: ", "Usuário cadastrado com sucesso!"
                , "success", true));
    }

    @GetMapping
    public ResponseEntity <List<UsuarioResponseDTO>> listAllUsuario (){
        return ResponseEntity.ok()
                .body(usuarioService.listAllUsuario());
    }

    @PutMapping ("/{id}")
    public ResponseEntity <Map<String, Object>> updateUsuario (@PathVariable Long id
    , @Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        usuarioService.updateUsuario(usuarioRequestDTO, id);
        return ResponseEntity.ok()
                .body(Map.of("message: ", "Usuário Atualizado com Sucesso!"
                , "success", true));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Map<String, Object>> deleteUsuario (@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok()
                .body(Map.of("message: ", "Usuário deletedo com sucesso!"
                , "success", true));
    }
}
