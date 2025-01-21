create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    contraseña varchar(100) not null unique,
    perfil varchar(13) not null unique,

    primary key(id)

);