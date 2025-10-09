package com.example.atvd7.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Cliente")

public class ClienteModel {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;
    @OneToOne (cascade = CascadeType.ALL)
    private EnderecoModel enderecoCliente;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nome, String email, EnderecoModel enderecoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.enderecoCliente = enderecoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public EnderecoModel getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(EnderecoModel enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", enderecoCliente=" + enderecoCliente +
                '}';
    }
}
