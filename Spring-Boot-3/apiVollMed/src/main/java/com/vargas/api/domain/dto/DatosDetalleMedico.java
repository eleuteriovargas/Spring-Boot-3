package com.vargas.api.domain.dto;

import com.vargas.api.domain.direccion.Direccion;
import com.vargas.api.domain.medico.Especialidad;
import com.vargas.api.domain.medico.Medico;

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
