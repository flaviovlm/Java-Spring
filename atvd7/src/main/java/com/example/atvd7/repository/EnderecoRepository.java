package com.example.atvd7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atvd7.model.EnderecoModel;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoModel, Long>{

}
