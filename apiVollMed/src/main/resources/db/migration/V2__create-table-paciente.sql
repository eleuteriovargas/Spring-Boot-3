create table pacientes(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    documento_identidad varchar(14) not null unique,
    telefono varchar(20) not null,
    calle varchar(100) not null,
    numero varchar(100),
    complemento varchar(100),
    barrio varchar(100) not null,
    ciudad varchar(100) not null,
    estado varchar(100) not null,
    codigo_postal varchar(9) not null,

    primary key(id)
);