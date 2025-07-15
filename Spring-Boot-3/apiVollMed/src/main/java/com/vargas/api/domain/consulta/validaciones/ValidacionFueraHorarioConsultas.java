package com.vargas.api.domain.consulta.validaciones;

import com.vargas.api.domain.ValidacionException;
import com.vargas.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidacionFueraHorarioConsultas implements ValidadorDeConsultas {
// Validación para verificar si la consulta está fuera del horario de atención de la clínica
    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeAperturaClinica = fechaConsulta.getHour() < 7;
        var horarioDespuesDeCierreClinica = fechaConsulta.getHour() > 18;
        if (domingo || horarioAntesDeAperturaClinica || horarioDespuesDeCierreClinica) {
            throw new ValidacionException("Horario seleccionado fuera del horario de atención de la clínica. ");
        }
    }
}
