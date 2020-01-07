-- Escrito en PostgreSQL

CREATE USER proyectuser WITH
    LOGIN
    SUPERUSER
    INHERIT
    CREATEDB
    CREATEROLE
    REPLICATION; -- ejecutar solo

alter user proyectuser with password 'caya'; -- ejecutar solo

CREATE DATABASE proyecto; -- ejecutar solo

create table public.tecnico(
    id_tecnico serial not null,
    nombre_tecnico varchar(100) not null,
    correo_tecnico varchar(100) not null,
    --nacimiento_tecnico date,
    contrasena_tecnico varchar(100) not null,
    primary key (id_tecnico)
);

create table public.cliente(
    id_cliente serial not null,
    nombre_cliente varchar(100) not null,
    correo_cliente varchar(100) not null,
    --nacimiento_cliente date,
    contrasena_cliente varchar(100) not null,
    primary key (id_cliente)
);

create table public.pago(
    id_pago serial not null,
    id_tecnico int not null,
    id_cliente int not null,
    id_consulta int not null,
    monto int not null,
    foreign key (id_tecnico) references tecnico(id_tecnico),
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_consulta) references consulta(id_consulta),
    primary key (id_pago)
);

create table public.consulta(
    id_consulta serial not null,
    id_tecnico int not null,
    id_cliente int not null,
    titulo varchar(100) not null,
    descripcion varchar(100) not null,
    categoria varchar(100) not null,
    --imagen_consulta bytea,
    foreign key (id_tecnico) references tecnico(id_tecnico),
    foreign key (id_cliente) references cliente(id_cliente),
    primary key (id_consulta)
);

create table public.calificacion(
    id_calificacion serial not null,
    id_tecnico int not null,
    id_cliente int not null,
    nota int not null,
    foreign key (id_tecnico) references tecnico(id_tecnico),
    foreign key (id_cliente) references cliente(id_cliente),
    primary key (id_calificacion)
);

create table public.mensajeria(
    id_mensajeria serial not null,
    id_tecnico int not null,
    id_cliente int not null,
    mensaje varchar(1000),
    --imagen_mensajeria bytea,
    foreign key (id_tecnico) references tecnico(id_tecnico),
    foreign key (id_cliente) references cliente(id_cliente),
    primary key (id_mensajeria)
);

/*
create table public.participantes(
    id_torneo int not null references torneo(id_torneo) ON UPDATE CASCADE ON DELETE CASCADE,
    id_equipo int not null references equipo(id_equipo) ON UPDATE CASCADE,
    CONSTRAINT torneo_equipo_pkey PRIMARY KEY (id_torneo, id_equipo)
);

create table public.partido(
    id_partido serial not null,
    id_torneo int not null,
    id_equipoA int not null,
    id_equipoB int not null,
    scoreA int default 0,
    scoreB int default 0,
    primary key (id_partido),
    foreign key (id_torneo) references torneo(id_torneo),
    foreign key (id_equipoA) references equipo(id_equipo),
    foreign key (id_equipoB) references equipo(id_equipo)
);

create table public.jugador(
    id_jugador serial not null,
    id_equipo int not null,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    apodo varchar(100),
    pais varchar(100),
    nacimiento date,
    primary key (id_jugador),
    foreign key (id_equipo) references equipo(id_equipo)
);*/