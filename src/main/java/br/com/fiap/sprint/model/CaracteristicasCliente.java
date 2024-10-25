package br.com.fiap.sprint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CaracteristicasCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String biotipo;

    private String estiloPreferencia;

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
