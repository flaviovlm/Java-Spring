package com.example.aula_validation2.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size (min = 3, message = "O nome deve ter o mínimo 3 caracteres")
    private String nome;
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Deve ser um email válido")
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    @Size (min = 3, max = 20, message = "A senha deve ter entre 3 e 20 caracteres!")
    private String senha;

    public UsuarioRequestDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @Size(min = 3, message = "O nome deve ter o mínimo 3 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@Size(min = 3, message = "O nome deve ter o mínimo 3 caracteres") String nome) {
        this.nome = nome;
    }

    public @Size(min = 3, message = "Deve ser um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@Size(min = 3, message = "Deve ser um email válido") String email) {
        this.email = email;
    }

    public @Size(min = 3, max = 20, message = "A senha deve ter entre 3 e 20 caracteres!") String getSenha() {
        return senha;
    }

    public void setSenha(@Size(min = 3, max = 20, message = "A senha deve ter entre 3 e 20 caracteres!") String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioRequestDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
