package com.example.atvd3.repository;

import com.example.atvd3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, UUID> {
    Optional <com.example.atvd3.model.Usuario> findByTelefone (String telefone);
}
