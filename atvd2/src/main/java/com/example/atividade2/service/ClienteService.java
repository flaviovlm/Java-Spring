package com.example.atividade2.service;

import com.example.atividade2.model.Cliente;
import com.example.atividade2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> listAll (){
        return  clienteRepository.findAll();
    }

    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void delete (UUID id){
        clienteRepository.deleteById(id);
    }

    public Cliente update (UUID id, Cliente cliente){
        if (clienteRepository.existsById(id)){
            return clienteRepository.save(cliente);
        }else {
           throw new RuntimeException("Usuario não encontrado.");
        }
    }
}
