package com.example.atvd6.repository;

import com.example.atvd6.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository <FuncionarioModel, Long> {
    Optional<FuncionarioModel> findByEmail (String Email);
}
