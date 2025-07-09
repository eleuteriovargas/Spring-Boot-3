package com.vargas.api.domain.dto;

import com.vargas.api.domain.paciente.Paciente;

public record DatosListaPaciente(
        Long id,
        String nombre,
        String email,
        String documentoIdentidad) {

    public DatosListaPaciente(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumentoIdentidad());
    }
}
