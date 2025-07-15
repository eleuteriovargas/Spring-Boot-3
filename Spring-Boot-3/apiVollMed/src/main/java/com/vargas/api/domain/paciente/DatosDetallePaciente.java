package com.vargas.api.domain.paciente;

import com.vargas.api.domain.direccion.Direccion;

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