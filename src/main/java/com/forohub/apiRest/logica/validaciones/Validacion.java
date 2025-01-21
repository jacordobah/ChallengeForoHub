package com.forohub.apiRest.logica.validaciones;


import com.forohub.apiRest.domain.topico.TopicoRepository;
import com.forohub.apiRest.domain.usuario.UsuarioRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Validacion {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepositoy usuarioRepositoy;

    
}
