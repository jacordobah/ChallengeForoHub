package com.forohub.apiRest.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;




public record TopicoRegistroDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Estado estado,
        @NotNull
        Long idUsuario,
        @NotNull
        Curso curso
){
}
