package com.example.atvd4.repository;

import com.example.atvd4.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, UUID> {
}
