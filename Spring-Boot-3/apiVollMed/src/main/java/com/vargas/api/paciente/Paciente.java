package com.vargas.api.paciente;

import com.vargas.api.direccion.Direccion;


import com.vargas.api.dto.DatosActualizacionMedico;
import com.vargas.api.dto.DatosActualizacionPaciente;
import com.vargas.api.dto.DatosRegistroPaciente;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import jakarta.persistence.*;

@Getter
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;
    private Boolean activo;

    @Embedded
    private Direccion direccion;

    public Paciente() {
    }

    public Paciente(DatosRegistroPaciente datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documento_identidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void atualizarInformacion(DatosActualizacionPaciente datos) {
        if (datos.nombre() != null)
            this.nombre = datos.nombre();

        if (datos.telefono() != null)
            this.telefono = datos.telefono();

        if (datos.direccion() != null)
            direccion. actualizarDireccion(datos.direccion());
    }

    public void desactivar() {

        this.activo = false;
    }

    public Long getId() {

        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void actualizarInformaciones(@Valid DatosActualizacionPaciente datos) {
        if (datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if (datos.telefono() != null){
            this.telefono = datos.telefono();
        }
        if (datos.direccion() != null){
            this.direccion.actualizarDireccion(datos.direccion());
        }
    }

    public void eliminar() {

        this.activo = false;
    }
}