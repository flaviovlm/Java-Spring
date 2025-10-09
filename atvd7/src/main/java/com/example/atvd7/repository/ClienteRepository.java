package com.example.atvd7.repository;

import com.example.atvd7.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel, Long> {
    Optional <ClienteModel> findByEmail (String email);
}
