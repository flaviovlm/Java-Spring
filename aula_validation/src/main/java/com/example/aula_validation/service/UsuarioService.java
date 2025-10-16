package com.example.aula_validation.service;

import java.util.List;

import com.example.aula_validation.dto.UsuarioRequestDTO;
import com.example.aula_validation.dto.UsuarioResponseDTO;
import com.example.aula_validation.exception.EmailCadastradoException;
import com.example.aula_validation.model.UsuarioModel;
import com.example.aula_validation.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List <UsuarioResponseDTO> listAllUsuario (){

        return usuarioRepository.findAll().
                stream()
                .map(usuarioModel -> new UsuarioResponseDTO(usuarioModel.getNome(),usuarioModel.getEmail()))
                .toList();
    }

    public UsuarioModel saveUsuario (UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw new EmailCadastradoException("Email já cadastrado!");
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));
        usuarioRepository.save(usuario);
        return usuario;
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