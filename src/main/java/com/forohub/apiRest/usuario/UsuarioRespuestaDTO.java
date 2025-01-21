package com.forohub.apiRest.usuario;

import com.forohub.apiRest.domain.topico.Curso;
import com.forohub.apiRest.domain.usuario.Perfil;

public record UsuarioRespuestaDTO(
    Long id,
    String nombre,
    Perfil perfil
) {
}
