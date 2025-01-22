package com.forohub.apiRest.logica.validaciones;


import com.forohub.apiRest.domain.ValidacionException;
import com.forohub.apiRest.domain.topico.Topico;
import com.forohub.apiRest.domain.topico.TopicoRepository;
import com.forohub.apiRest.domain.usuario.Usuario;
import com.forohub.apiRest.domain.usuario.UsuarioRepositoy;
import com.forohub.apiRest.domain.topico.TopicoRegistroDTO;
import com.forohub.apiRest.domain.topico.TopicoRespuestaDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Validacion {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepositoy usuarioRepositoy;

     @Transactional
    public TopicoRespuestaDTO crear(@Valid TopicoRegistroDTO topicoRegistroDTO) {
        if(!usuarioRepositoy.existsById(topicoRegistroDTO.idUsuario())){
            throw new ValidacionException("No existe el usuario");
        }
        List<Topico> topicos = topicoRepository.findByTituloContainingIgnoreCase(topicoRegistroDTO.titulo());
        if(!topicos.isEmpty()){
            topicos.forEach(topico -> {
                if(topico.getMensaje().equalsIgnoreCase(topicoRegistroDTO.mensaje())){
                    throw new ValidacionException("Ya existe ese tópico en el foro");
                }
            });
        }
        Usuario usuario = usuarioRepositoy.findById(topicoRegistroDTO.idUsuario()).get();
        var topicoRegistrado = topicoRepository.save(new Topico(topicoRegistroDTO,usuario));
        return new TopicoRespuestaDTO(topicoRegistrado);
    }
}
