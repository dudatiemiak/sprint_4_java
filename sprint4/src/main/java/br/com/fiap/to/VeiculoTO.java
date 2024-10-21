package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class VeiculoTO {
    private Long codigo;
    @NotBlank
    private String placa;
    @NotBlank
    private String tipo;
    @PositiveOrZero
    private float quilometragem;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @Positive
    private int ano;

    public VeiculoTO() {
    }

    public VeiculoTO(Long codigo, @NotBlank String placa, @NotBlank String tipo, @PositiveOrZero float quilometragem, @NotBlank String marca, @NotBlank String modelo, @Positive int ano) {
        this.codigo = codigo;
        this.placa = placa;
        this.tipo = tipo;
        this.quilometragem = quilometragem;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank String placa) {
        this.placa = placa;
    }

    public @NotBlank String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank String tipo) {
        this.tipo = tipo;
    }

    @PositiveOrZero
    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(@PositiveOrZero float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank String marca) {
        this.marca = marca;
    }

    public @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank String modelo) {
        this.modelo = modelo;
    }

    @Positive
    public int getAno() {
        return ano;
    }

    public void setAno(@Positive int ano) {
        this.ano = ano;
    }
}
