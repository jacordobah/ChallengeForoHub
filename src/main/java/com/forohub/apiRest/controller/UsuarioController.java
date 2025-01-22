package com.forohub.apiRest.controller;


import com.forohub.apiRest.domain.usuario.Usuario;
import com.forohub.apiRest.domain.usuario.UsuarioRepositoy;
import com.forohub.apiRest.domain.usuario.UsuarioRegistroDTO;
import com.forohub.apiRest.domain.usuario.UsuarioRespuestaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepositoy repositoy;

    @PostMapping
    public ResponseEntity<UsuarioRespuestaDTO> registrar(@RequestBody @Valid UsuarioRegistroDTO usuarioRegistroDTO,
                                                         UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario =repositoy.save(new Usuario(usuarioRegistroDTO));
        UsuarioRespuestaDTO respuestaDTO = new UsuarioRespuestaDTO(usuario.getId(), usuario.getNombre(),
                usuario.getPerfil());
        URI url = uriComponentsBuilder.path("/Usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaDTO);
    }


}
