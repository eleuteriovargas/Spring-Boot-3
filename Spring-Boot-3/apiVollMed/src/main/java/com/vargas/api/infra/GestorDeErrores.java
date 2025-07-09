package com.vargas.api.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GestorDeErrores {

    //Tratando error 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarErro404(){
        return ResponseEntity.notFound().build();
    }

    //Tratando error 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarErro400(MethodArgumentNotValidException ex){

        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream().map(DatosErrorValidacion::new).toList());
    }

    public record DatosErrorValidacion(String campo,
                                       String mensaje
    ){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
