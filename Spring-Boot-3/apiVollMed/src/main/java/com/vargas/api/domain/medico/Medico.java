package com.vargas.api.domain.medico;

import com.vargas.api.domain.direccion.Direccion;
import com.vargas.api.domain.dto.DatosActualizacionMedico;
import com.vargas.api.domain.dto.DatosRegistroMedico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;


@Table(name = "medicos")
@Entity(name = "Medico")
@EqualsAndHashCode(of = "id")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded //En la base de datos se unen las columnas de la tabla medico con las de la direccion
    private Direccion direccion;


    public Medico() {
    }

    public Medico(DatosRegistroMedico datos) {
        this.id = null;
        this.activo =true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());

    }

    public Long getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void actualizarInformaciones(@Valid DatosActualizacionMedico datos) {
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
