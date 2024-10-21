package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OficinaTO {
    private Long codigo;
    @NotBlank
    private String nome_oficina;
    @NotNull
    private Long cnpj;
    @NotBlank
    private String status;
    @NotBlank
    private String cep;

    public OficinaTO() {
    }

    public OficinaTO(Long codigo, @NotBlank String nome_oficina, @NotNull Long cnpj, @NotBlank String status, @NotBlank String cep) {
        this.codigo = codigo;
        this.nome_oficina = nome_oficina;
        this.cnpj = cnpj;
        this.status = status;
        this.cep = cep;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNome_oficina() {
        return nome_oficina;
    }

    public void setNome_oficina(@NotBlank String nome_oficina) {
        this.nome_oficina = nome_oficina;
    }

    public @NotNull Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull Long cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }

    public @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotBlank String cep) {
        this.cep = cep;
    }
}
