package com.forohub.apiRest.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nombre;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    public Usuario(){}
    public Usuario(@Valid UsuarioRegistroDTO usuarioRegistroDTO) {
        this.nombre = usuarioRegistroDTO.nombre();
        this.contrasena = usuarioRegistroDTO.contrasena();
        this.perfil = usuarioRegistroDTO.perfil();
    }
    //@OneToMany(mappedBy = "Topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<Topico> topicos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
