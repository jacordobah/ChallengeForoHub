package com.forohub.apiRest.topico;

import com.forohub.apiRest.domain.topico.Curso;
import com.forohub.apiRest.domain.topico.Estado;
import jakarta.validation.constraints.NotBlank;


public record TopicoRegistroDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        Estado estado,
        @NotBlank
        Long idUsuario,
        @NotBlank
        Curso curso
){
}
