package com.forohub.apiRest.controller;

import com.forohub.apiRest.domain.topico.TopicoRepository;
import com.forohub.apiRest.logica.validaciones.Validacion;
import com.forohub.apiRest.domain.topico.TopicoRegistroDTO;
import com.forohub.apiRest.domain.topico.TopicoRespuestaDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
