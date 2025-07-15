package com.vargas.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosDireccion(
       @NotBlank String calle,
        String numero, //Es un dato opcional
        String complemento,
       @NotBlank String barrio,
       @NotBlank String ciudad,
       @NotBlank @Pattern(regexp = "\\d{4}") String codigo_postal,
       @NotBlank String estado) {
}
