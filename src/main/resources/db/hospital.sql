DROP DATABASE IF EXISTS hospital;
CREATE DATABASE hospital;
USE hospital;
CREATE TABLE doctores
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE consultorios
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    numero_de_consultorio BIGINT NOT NULL,
    piso INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (numero_de_consultorio)
);

CREATE TABLE pacientes
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE citas
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_consultorio BIGINT NOT NULL,
    id_doctor BIGINT NOT NULL,
    nombre_del_paciente VARCHAR(100) NOT NULL,
    horario DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_consultorio
        FOREIGN KEY (id_consultorio)
            REFERENCES consultorios (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    CONSTRAINT fk_doctor
        FOREIGN KEY (id_doctor)
            REFERENCES doctores (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    UNIQUE (id_consultorio, horario),
    UNIQUE (id_doctor, horario),
    UNIQUE (nombre_del_paciente, horario)
);

CREATE INDEX idx_horario
    ON citas (horario);

INSERT INTO doctores (nombre, apellido_paterno, apellido_materno, especialidad)
VALUES ('Juan', 'Pérez', 'García', 'Cardiología'),
       ('María', 'González', 'López', 'Pediatría'),
       ('José', 'Martínez', 'Hernández', 'Oftalmología'),
       ('Ana', 'Rodríguez', 'Díaz', 'Dermatología'),
         ('Francisco', 'Hernández', 'Moreno', 'Ginecología');

INSERT INTO consultorios (numero_de_consultorio, piso)
VALUES (101, 1),
        (102, 1),
        (103, 1),
        (104, 1),
        (105, 1),
        (201, 2),
        (202, 2),
        (203, 2),
        (204, 2),
        (205, 2),
        (301, 3),
        (302, 3),
        (303, 3),
        (304, 3),
        (305, 3);