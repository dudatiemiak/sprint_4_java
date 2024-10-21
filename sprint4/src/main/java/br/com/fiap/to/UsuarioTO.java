package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UsuarioTO {
    private Long codigo;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
    private String senha;
    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
    private String cpf;

    public UsuarioTO() {
    }

    public UsuarioTO(Long codigo, @NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres") String senha, @NotBlank @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos") String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres") String senha) {
        this.senha = senha;
    }

    public @NotBlank @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos") String cpf) {
        this.cpf = cpf;
    }
}
