create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje text not null,
    estado varchar(20) not null,
    usuario_id bigint not null,
    curso varchar (50),

    primary key(id),
    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)
);