package com.example.atvd3.service;

import com.example.atvd3.model.Cliente;
import com.example.atvd3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List <Cliente> listAll (){
        return clienteRepository.findAll();
    }

    public Cliente save (Cliente cliente){
        if (clienteRepository.findByprotocoloAtendimento(cliente.getProtocoloAtendimento()).isPresent()){
            throw  new RuntimeException("Cliente já cadastrado");
        }
        return clienteRepository.save(cliente);
    }
}
