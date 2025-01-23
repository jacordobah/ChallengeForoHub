package com.forohub.apiRest.domain.topico;

import jakarta.validation.constraints.NotNull;

public record TopicoActualizarDTO(@NotNull Long id, String titulo, String mensaje,Estado estado) {
}
