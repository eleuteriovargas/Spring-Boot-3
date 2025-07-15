package com.vargas.api.controller;

import com.vargas.api.domain.medico.DatosActualizacionMedico;
import com.vargas.api.domain.medico.DatosDetalleMedico;
import com.vargas.api.domain.medico.DatosListaMedico;
import com.vargas.api.domain.medico.DatosRegistroMedico;
import com.vargas.api.domain.medico.Medico;
import com.vargas.api.domain.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class medicoController {

    @Autowired
    private MedicoRepository repository;

    //@Transactional es para realizar transacciones de spring
    //@Valid es para validar los datos de bean validation
    @Transactional
    @PostMapping
    //Devolver un 201, body, Header Location
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroMedico datos, UriComponentsBuilder uriComponentsBuilder){
        //la tabla Medico va a recibir datos del DTO DatosRegistroMedico y se van en una entidad JPA
        var medico = new Medico(datos);
        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleMedico(medico));
    }

    @GetMapping
    //metodo para paginacion
    //Devolver un 200
    public ResponseEntity<Page<DatosListaMedico>> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion){
        var page = repository.findAllByActivoTrue(paginacion).map(DatosListaMedico::new);

        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    //Devolver un 200
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionMedico datos) {
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DatosDetalleMedico(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    //Devolver un 204 No Contect
    public ResponseEntity eliminar (@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.eliminar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleMedico(medico));
    }




}
