package com.example.aula_validation2.service;

import com.example.aula_validation2.dto.UsuarioRequestDTO;
import com.example.aula_validation2.dto.UsuarioResponseDTO;
import com.example.aula_validation2.exception.EmailException;
import com.example.aula_validation2.model.UsuarioModel;
import com.example.aula_validation2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public List <UsuarioResponseDTO> listAllUsuario (){
        return usuarioRepository
                .findAll()
                .stream()
                .map(usuarioModel -> new UsuarioResponseDTO(usuarioModel.getNome(), usuarioModel.getEmail()))
                .toList();

    }

    public UsuarioModel saveUsuario (UsuarioRequestDTO dto){
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new EmailException("Email já cadastrado!");
        }
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
        usuarioRepository.save(usuario);
        return usuario;
    }

    public UsuarioModel updateUsuario (UsuarioRequestDTO dto, Long id){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado");
        }
        UsuarioModel atualizarUsuario = new UsuarioModel();
        atualizarUsuario.setNome(dto.getNome());
        atualizarUsuario.setEmail(dto.getEmail());
        atualizarUsuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
        usuarioRepository.save(atualizarUsuario);
        atualizarUsuario.setId(id);
        return atualizarUsuario;
        }

        public void deleteUsuario (Long id){
        if (!usuarioRepository.existsById(id)){
            throw new IllegalArgumentException("Usuário não encontrado!");
        }

        usuarioRepository.deleteById(id);

    }

}

