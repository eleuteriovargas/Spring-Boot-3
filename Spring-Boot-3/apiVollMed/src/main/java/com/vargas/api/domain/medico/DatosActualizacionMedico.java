package com.vargas.api.domain.medico;


import com.vargas.api.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;
;


public record DatosActualizacionMedico(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {

}
