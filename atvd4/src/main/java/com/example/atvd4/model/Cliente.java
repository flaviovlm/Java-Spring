package com.example.atvd4.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Cliente {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;

    public Cliente() {
    }

    public Cliente(UUID id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
