package com.example.atvd3.controller;

import com.example.atvd3.model.Cliente;
import com.example.atvd3.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List <Cliente> listAll (){
        return clienteService.listAll();
    }

    @PostMapping
    public ResponseEntity <Cliente> save (@RequestBody Cliente cliente){

        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
