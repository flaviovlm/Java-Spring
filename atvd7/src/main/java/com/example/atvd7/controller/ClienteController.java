package com.example.atvd7.controller;

import com.example.atvd7.model.ClienteModel;
import com.example.atvd7.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List <ClienteModel> listAllCliente (){
        return clienteService.listAllCliente();

    }

    @PostMapping
    public ResponseEntity <Map<String,Object>> saveCliente (@RequestBody ClienteModel cliente){
        clienteService.saveCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message: ", "Cliente cadastrado!", "success", true));
    }

    @PutMapping ("/{id}")
    public ResponseEntity <Map<String,Object>> updateCliente (@RequestBody ClienteModel cliente, @PathVariable Long id){
        clienteService.updateCliente(cliente, id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message: ", "Cliente Atualizado!", "success", true));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Map<String,Object>> deleteCliente (@RequestBody ClienteModel cliente, @PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message: ", "Cliente deletado!", "success", true));

    }
}
