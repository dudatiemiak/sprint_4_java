package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ServicosTO {
    private Long codigo;
    @NotBlank
    private String placa1;
    @NotBlank
    private String motivo;
    @Positive
    private float valor;
    @NotNull
    @PastOrPresent
    private LocalDate dt_entrada;
    @NotNull
    @FutureOrPresent
    private LocalDate dt_saida;

    public ServicosTO() {
    }

    public ServicosTO(Long codigo, @NotBlank String placa1, @NotBlank String motivo, @Positive float valor, @NotNull @PastOrPresent LocalDate dt_entrada, @NotNull @FutureOrPresent LocalDate dt_saida) {
        this.codigo = codigo;
        this.placa1 = placa1;
        this.motivo = motivo;
        this.valor = valor;
        this.dt_entrada = dt_entrada;
        this.dt_saida = dt_saida;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getPlaca1() {
        return placa1;
    }

    public void setPlaca1(@NotBlank String placa1) {
        this.placa1 = placa1;
    }

    public @NotBlank String getMotivo() {
        return motivo;
    }

    public void setMotivo(@NotBlank String motivo) {
        this.motivo = motivo;
    }

    @Positive
    public float getValor() {
        return valor;
    }

    public void setValor(@Positive float valor) {
        this.valor = valor;
    }

    public @NotNull @PastOrPresent LocalDate getDt_entrada() {
        return dt_entrada;
    }

    public void setDt_entrada(@NotNull @PastOrPresent LocalDate dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    public @NotNull @FutureOrPresent LocalDate getDt_saida() {
        return dt_saida;
    }

    public void setDt_saida(@NotNull @FutureOrPresent LocalDate dt_saida) {
        this.dt_saida = dt_saida;
    }
}
