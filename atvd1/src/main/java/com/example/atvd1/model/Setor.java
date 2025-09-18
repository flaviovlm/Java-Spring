package com.example.atvd1.model;

public enum Setor {
    ENGENHARIA ("Engenharia"),
    SAUDE ("Saude"),
    JURIDICO ("Juridico");

    private String nome;

    Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Setor{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

