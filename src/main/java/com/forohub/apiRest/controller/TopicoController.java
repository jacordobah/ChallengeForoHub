package com.forohub.apiRest.controller;

import com.forohub.apiRest.domain.ValidacionException;
import com.forohub.apiRest.domain.topico.*;
import com.forohub.apiRest.logica.validaciones.Validacion;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private Validacion validar;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoRespuestaDTO> registrar(@RequestBody @Valid TopicoRegistroDTO topicoRegistroDTO){
        var detalleTopico = validar.crear(topicoRegistroDTO);
        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoRespuestaDTO>> consultarTodos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(repository.findAll(paginacion).map(TopicoRespuestaDTO::new));
    }

    @GetMapping("{id}")
    public ResponseEntity<TopicoRespuestaDTO> consultarPorId(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        var topicoRespuesta = new TopicoRespuestaDTO(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha());
        return ResponseEntity.ok(topicoRespuesta);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<TopicoRespuestaDTO> actualizar(@RequestBody @Valid TopicoActualizarDTO topicoActualizar){
        Optional<Topico> topicoOptional = repository.findById(topicoActualizar.id());
        if (topicoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TopicoRespuestaDTO(topicoActualizar.id(),
                    null,"No Existe Topico",null));
        }
        Topico topico = topicoOptional.get();
        topico.actualizar(topicoActualizar);
        return ResponseEntity.ok(new TopicoRespuestaDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha()));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id){
        Optional<Topico> topicoOptional = repository.findById(id);
        if(topicoOptional.isPresent()) {
            repository.deleteById(id);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.noContent().build();
    }





}
