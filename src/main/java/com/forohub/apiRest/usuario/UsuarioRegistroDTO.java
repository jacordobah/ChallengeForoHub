package com.forohub.apiRest.usuario;

import com.forohub.apiRest.domain.usuario.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRegistroDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String contrasena,
        @NotNull Perfil perfil

) {
}
