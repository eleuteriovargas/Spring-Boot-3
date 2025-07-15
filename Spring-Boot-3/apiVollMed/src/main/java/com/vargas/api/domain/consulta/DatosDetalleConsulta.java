package com.vargas.api.domain.consulta;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime fecha) {
}
