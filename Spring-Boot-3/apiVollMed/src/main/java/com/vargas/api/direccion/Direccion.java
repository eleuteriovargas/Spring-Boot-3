package com.vargas.api.direccion;

import com.vargas.api.dto.DatosDireccion;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String ciudad;
    private String codigo_postal;
    private String estado;

    public Direccion() {}

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.ciudad = datosDireccion.ciudad();
        this.codigo_postal = datosDireccion.codigo_postal();
        this.estado = datosDireccion.estado();
    }


    public void actualizarDireccion(DatosDireccion datos) {
        if (datos.calle() != null){
            this.calle = datos.calle();
        }
        if (datos.numero() != null){
            this.numero = datos.numero();
        }
        if (datos.complemento() != null){
            this.complemento = datos.complemento();
        }
        if (datos.barrio() != null){
            this.barrio = datos.barrio();
        }
        if (datos.ciudad() != null){
            this.ciudad = datos.ciudad();
        }
        if (datos.codigo_postal() != null){
            this.codigo_postal = datos.codigo_postal();
        }
        if (datos.estado() != null){
            this.estado = datos.estado();
        }
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public String getEstado() {
        return estado;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

