package com.example.atvd3.service;

import com.example.atvd3.model.Usuario;
import com.example.atvd3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listAll (){
        return usuarioRepository.findAll();
    }

    public Usuario save (Usuario usuario){
        if (usuarioRepository.findByTelefone(usuario.getTelefone()).isPresent()){
            throw new RuntimeException("Usuario já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }
}
