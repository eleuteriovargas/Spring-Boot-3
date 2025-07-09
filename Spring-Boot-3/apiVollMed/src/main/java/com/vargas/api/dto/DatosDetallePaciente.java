package com.vargas.api.dto;

import com.vargas.api.direccion.Direccion;
import com.vargas.api.paciente.Paciente;

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