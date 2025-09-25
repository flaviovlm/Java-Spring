package com.example.atvd4.controller;

import com.example.atvd4.model.Cliente;
import com.example.atvd4.repository.ClienteRepository;
import com.example.atvd4.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping ("/{id}")
    public ResponseEntity <Cliente> update (@PathVariable UUID id, @RequestBody Cliente cliente){

        clienteService.update(id,cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete (@PathVariable UUID id){
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
