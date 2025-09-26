package com.example.atvd4.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Endereco {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String logradouro;
    @Column (nullable = false)
    private int numero;
    @Column (nullable = false)
    private String cidade;

    public Endereco() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
