package com.vargas.api.dto;

import com.vargas.api.direccion.Direccion;
import com.vargas.api.medico.Especialidad;
import com.vargas.api.medico.Medico;

public record DatosDetalleMedico(
        Long id,
        String nombre,
        String email,
        String documento,
        String telefono,
        Especialidad especialidad,
        Direccion direccion
) {

    public DatosDetalleMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getTelefono(),
                medico.getEspecialidad(),
                medico.getDireccion()
        );
    }
}
