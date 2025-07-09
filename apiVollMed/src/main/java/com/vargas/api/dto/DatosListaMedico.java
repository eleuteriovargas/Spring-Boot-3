package com.vargas.api.dto;

import com.vargas.api.medico.Especialidad;
import com.vargas.api.medico.Medico;

public record DatosListaMedico(
        Long id,
        String nombre,
        String email,
        String documento,
        Especialidad especialidad
) {
    public DatosListaMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad());
    }


}






