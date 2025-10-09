package com.example.atvd7.repository;

import java.util.Optional;

import com.example.atvd7.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atvd7.controller.FuncionarioController;

@Repository
public interface FuncionarioRepository extends JpaRepository <FuncionarioModel, Long> {
    Optional <FuncionarioModel> findByMatricula (String matricula);
    Optional <FuncionarioModel> findByEmail (String email);
}
