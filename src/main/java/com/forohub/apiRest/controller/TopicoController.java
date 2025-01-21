package com.forohub.apiRest.controller;

import com.forohub.apiRest.domain.topico.Topico;
import com.forohub.apiRest.domain.topico.TopicoRepository;
import com.forohub.apiRest.topico.TopicoRegistroDTO;
import com.forohub.apiRest.topico.TopicoRespuestaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;


    public ResponseEntity<TopicoRespuestaDTO> registrar(@RequestBody @Valid TopicoRegistroDTO topicoRegistroDTO){
        return null;
    }

}
