package br.com.fiap.sprint.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class CaracteristicasClienteDTO {

    private Long id;

    @NotBlank(message = "Valor não pode ser nulo e nem vazio")
    private String biotipo;

    @NotBlank
    private String estiloPreferencia;

    @NotBlank
    private String colorometria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.biotipo = biotipo;
    }

    public String getEstiloPreferencia() {
        return estiloPreferencia;
    }

    public void setEstiloPreferencia(String estiloPreferencia) {
        this.estiloPreferencia = estiloPreferencia;
    }

    public String getColorometria() {
        return colorometria;
    }

    public void setColorometria(String colorometria) {
        this.colorometria = colorometria;
    }
}
