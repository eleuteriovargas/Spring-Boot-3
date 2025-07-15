package com.vargas.api.domain.consulta.validaciones;

import com.vargas.api.domain.ValidacionException;
import com.vargas.api.domain.consulta.DatosReservaConsulta;
import com.vargas.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoActivo implements ValidadorDeConsultas {

@Autowired
    private MedicoRepository repository;

    @Override
    public void validar(DatosReservaConsulta datos) {
        if (datos.idMedico() == null){
            return; // No hay médico seleccionado, no se valida
        }
        var medicoEstaActivo = repository.findActivoById(datos.idMedico());
        if (!medicoEstaActivo) {
            throw new ValidacionException("Consulta no puede ser reservada con un médico inactivo.");
        }

    }
}
