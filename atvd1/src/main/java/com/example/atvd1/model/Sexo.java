package com.example.atvd1.model;

public enum Sexo {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino");

    private String text;

    Sexo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Sexo{" +
                "text='" + text + '\'' +
                '}';
    }
}
