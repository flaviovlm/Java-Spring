package com.example.atvd3.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Funcionario {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String telefone;
    @Column (nullable = false, unique = true)
    private String cpf;
    @Column (nullable = false, unique = true)
    private String rg;
    @Column (nullable = false, unique = true)
    private String matricula;
    @Column (nullable = false)
    private String dataNascimento;
    @Column (nullable = false)
    private double salario;
    @Column (nullable = false, unique = true)
    private String email;

    public Funcionario() {
    }

    public Funcionario(UUID id, String nome, String telefone, String cpf, String rg, String matricula, String dataNascimento, double salario, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
