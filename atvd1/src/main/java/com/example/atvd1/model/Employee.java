package com.example.atvd1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;

import java.util.Set;
import java.util.UUID;

@Entity
public class Employee {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false, unique = true)
    private String cpf;

    @Column (nullable = false, unique = true)
    private String rg;

    @Column (nullable = false, unique = true)
    private String matricula;

    @Column (nullable = false)
    private String dataNascimento;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private Sexo sexo;
    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private Setor setor;

    @Column (nullable = false)
    private double salario;
    @Column (nullable = false, unique = true)
    private String telefone;
    @Column (nullable = false, unique = true)
    private String email;

    @OneToOne (cascade = CascadeType.ALL)
    private Address address;

    public Employee() {
    }

    public Employee(Long id, String nome, String cpf, String rg, String matricula, String dataNascimento, Sexo sexo, Setor setor, double salario, String telefone, String email, Address address) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.salario = salario;
        this.telefone = telefone;
        this.email = email;
        this.address = address;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", sexo=" + sexo +
                ", setor=" + setor +
                ", salario=" + salario +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
