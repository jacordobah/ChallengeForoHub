package com.forohub.apiRest.domain.topico;

import com.forohub.apiRest.domain.usuario.Usuario;
import com.forohub.apiRest.topico.TopicoRegistroDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private Curso curso;


    public Topico(@Valid TopicoRegistroDTO topicoRegistroDTO, Usuario usuario) {
        this.titulo = topicoRegistroDTO.titulo();
        this.mensaje = topicoRegistroDTO.mensaje();
        this.estado = topicoRegistroDTO.estado();
        this.usuario = usuario;

    }
}
