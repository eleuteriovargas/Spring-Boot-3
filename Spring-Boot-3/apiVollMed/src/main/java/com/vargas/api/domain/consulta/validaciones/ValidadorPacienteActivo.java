package com.vargas.api.domain.consulta.validaciones;


import com.vargas.api.domain.ValidacionException;
import com.vargas.api.domain.consulta.DatosReservaConsulta;
import com.vargas.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository repository;

    public void validar(DatosReservaConsulta datos){
        var pacienteEstaActivo = repository.findActivoById(datos.idPaciente());
        if(!pacienteEstaActivo){
            throw new ValidacionException("Consulta no puede ser reservada con paciente excluido");
        }
    }
}