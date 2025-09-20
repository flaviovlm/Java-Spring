package com.example.atividade2.repository;

import com.example.atividade2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface ClienteRepository extends JpaRepository <Cliente, UUID> {
}
