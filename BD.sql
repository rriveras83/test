CREATE DATABASE sample
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE public.alumnos
(
    id serial NOT NULL,
    nombre character varying(60),
    paterno character varying(60),
    materno character varying(60),
    matricula character varying(10),
    "updateDate" date,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.alumnos
    OWNER to postgres;

CREATE TABLE public.profesores
(
    id serial NOT NULL,
    nombre character varying(60),
    paterno character varying(60),
    materno character varying(60),
    "updateDate" date,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.profesores
    OWNER to postgres;

CREATE TABLE public.carreras
(
    "Id" serial NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text,
    "updateDate" date,
    PRIMARY KEY ("Id")
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.carreras
    OWNER to postgres;

CREATE TABLE public.materias
(
    id serial NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion text,
    creditos integer NOT NULL,
    "updateDate" date,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.materias
    OWNER to postgres;