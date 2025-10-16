package com.example.aula_validation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank (message = "O nome é obrigatório, panaca!")
    private String nome;
    @NotBlank (message = "O Email é obrigatório, pateta!")
    @Email(message = "Dever ser um email válido!")
    private String email;
    @NotBlank (message = "A senha é obrigatória, excomungado!")
    @Size (min = 3, max = 20, message = ("A senha deve ter entre 3 à 20 caracteres."))
    private String senha;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatório, panaca!") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório, panaca!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O Email é obrigatório, pateta!") @Email(message = "Dever ser um email válido!") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O Email é obrigatório, pateta!") @Email(message = "Dever ser um email válido!") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatória, excomungado!") @Size(min = 3, max = 20, message = ("A senha deve ter entre 3 à 20 caracteres.")) String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatória, excomungado!") @Size(min = 3, max = 20, message = ("A senha deve ter entre 3 à 20 caracteres.")) String senha) {
        this.senha = senha;
    }
}
