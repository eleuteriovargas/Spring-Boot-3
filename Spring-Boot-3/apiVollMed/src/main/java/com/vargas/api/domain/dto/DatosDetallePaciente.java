package com.vargas.api.domain.dto;

import com.vargas.api.domain.direccion.Direccion;
import com.vargas.api.domain.paciente.Paciente;

public record DatosDetallePaciente(
        String nombre,
        String email,
        String telefono,
        String documentoIdentidad,
        Direccion direccion)
{
    public DatosDetallePaciente(Paciente paciente) {

        this(paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente. getDocumentoIdentidad(),
                paciente.getDireccion());
    }
}