package com.example.atvd3.controller;


import com.example.atvd3.model.Usuario;
import com.example.atvd3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listAll (){
        return usuarioService.listAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> save (@RequestBody Usuario usuario){

        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
