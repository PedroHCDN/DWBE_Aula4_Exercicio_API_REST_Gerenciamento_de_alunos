package com.aulas.gerenciadoralunos.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class Aluno {
    @NotNull(message = "RA não pode ser nulo")
    private Integer ra;

    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "Email não pode estar vazio")
    @Email(message = "Email inválido, tem que ter @")
    private String email;

    public Aluno(){}

    public Aluno(Integer ra, String nome, String email) {
        this.email = email;
        this.nome = nome;
        this.ra = ra;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
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
