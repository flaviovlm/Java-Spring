package com.example.atvd5.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atvd5.exception.EmailCadastradoException;
import com.example.atvd5.model.UsuarioModel;
import com.example.atvd5.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List <UsuarioModel> listAll (){

        return usuarioRepository.findAll();

    }

    public UsuarioModel saveUsuario (UsuarioModel usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new EmailCadastradoException("Usuário já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel updateUsuario (UsuarioModel usuario, Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!") ;
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario (Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado!") ;
        }

        usuarioRepository.deleteById(id);
        
    }
    

}
