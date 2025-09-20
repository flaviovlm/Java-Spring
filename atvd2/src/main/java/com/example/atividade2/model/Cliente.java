package com.example.atividade2.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Cliente {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String telefone;

    public Cliente() {
    }

    public Cliente(UUID id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
