package com.vargas.api.controller;

import com.vargas.api.dto.DatosActualizacionMedico;
import com.vargas.api.dto.DatosListaMedico;
import com.vargas.api.dto.DatosRegistroMedico;
import com.vargas.api.medico.Medico;
import com.vargas.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class medicoController {

    @Autowired
    private MedicoRepository repository;

    //@Transactional es para realizar transacciones de spring
    //@Valid es para validar los datos de bean validation
    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos){
        //la tabla Medico va a recibir datos del DTO DatosRegistroMedico y se van en una entidad JPA
        repository.save(new Medico(datos));

    }


    @GetMapping
    //metodo para paginacion
    public Page<DatosListaMedico> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion){
        return repository.findAllByActivoTrue(paginacion).map(DatosListaMedico::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionMedico datos){
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarInformaciones(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.eliminar();;
    }

}
