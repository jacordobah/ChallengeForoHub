package com.forohub.apiRest.domain.topico;

import com.forohub.apiRest.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;


import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
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
    private LocalDateTime fecha;


    public Topico(TopicoRegistroDTO topicoRegistroDTO, Usuario usuario) {
        this.titulo = topicoRegistroDTO.titulo();
        this.mensaje = topicoRegistroDTO.mensaje();
        this.estado = topicoRegistroDTO.estado();
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;

    }

    public Topico(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void actualizar(@Valid TopicoActualizarDTO topicoActualizar) {
        if(topicoActualizar.titulo()!=null){
            this.setTitulo(topicoActualizar.titulo());
        }
        if(topicoActualizar.mensaje()!=null){
            this.setMensaje(topicoActualizar.mensaje());
        }
        if(topicoActualizar.estado()!=null){
            this.setEstado(topicoActualizar.estado());
        }
    }
}
