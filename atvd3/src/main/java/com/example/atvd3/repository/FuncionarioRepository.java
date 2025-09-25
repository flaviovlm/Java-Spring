package com.example.atvd3.repository;

import com.example.atvd3.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, UUID> {
    Optional<Funcionario> findByTelefone (String telefone);
}
