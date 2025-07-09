package com.vargas.api.domain.dto;


import jakarta.validation.constraints.NotNull;
;


public record DatosActualizacionMedico(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {

}
