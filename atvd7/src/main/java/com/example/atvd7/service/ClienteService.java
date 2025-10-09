package com.example.atvd7.service;

import com.example.atvd7.exception.EmailException;
import com.example.atvd7.model.ClienteModel;
import com.example.atvd7.model.FuncionarioModel;
import com.example.atvd7.repository.ClienteRepository;
import com.example.atvd7.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listAllCliente (){
        return clienteRepository.findAll();
    }

    public ClienteModel saveCliente (ClienteModel cliente){
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new EmailException("Email já cadastrado, tente novamente!");
        }

        return clienteRepository.save(cliente);
    }
    public ClienteModel updateCliente (ClienteModel cliente, Long id){
        if (!clienteRepository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deleteCliente (Long id){
        if (!clienteRepository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado!");

        }

        clienteRepository.deleteById(id);
    }

}
