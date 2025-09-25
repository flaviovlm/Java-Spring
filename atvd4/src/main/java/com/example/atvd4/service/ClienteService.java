package com.example.atvd4.service;

import com.example.atvd4.model.Cliente;
import com.example.atvd4.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List <Cliente> listAll (){

        return clienteRepository.findAll();
    }

    public void save (Cliente cliente){
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado!");
        }

        clienteRepository.save(cliente);
    }

    public Cliente update (UUID id, Cliente cliente){
        if (!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado!");
        }

        cliente.setId(id);
         return clienteRepository.save(cliente);
    }

    public void delete (UUID id){
        if (!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado!");
        }

        clienteRepository.deleteById(id);
    }
}
