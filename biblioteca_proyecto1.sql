-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2025 a las 07:11:23
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca_proyecto1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE `artistas` (
  `id` int(11) NOT NULL,
  `nombre_artista` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `artistas`
--

INSERT INTO `artistas` (`id`, `nombre_artista`) VALUES
(1, 'Jimi Hendrix'),
(2, 'Axl Rose'),
(3, 'Harrison Ford'),
(4, 'Clint Eastwood'),
(5, 'Arnold Schwarzenegger'),
(6, 'Gary Lockwood'),
(7, 'Jimi Hendrix'),
(8, 'Axl Rose'),
(9, 'Harrison Ford'),
(10, 'Clint Eastwood'),
(11, 'Arnold Schwarzenegger'),
(12, 'Gary Lockwood');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE `autores` (
  `id` int(11) NOT NULL,
  `nombre_autor` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`id`, `nombre_autor`) VALUES
(1, 'William Shakespeare'),
(2, 'Agatha Christie'),
(3, 'Dr. Seuss'),
(4, 'Akira Toriyama'),
(5, 'J. K. Rowling'),
(6, 'Pablo Neruda'),
(7, 'Agatha Christie'),
(8, 'Dr. Seuss'),
(9, 'Akira Toriyama'),
(10, 'J. K. Rowling');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `directores`
--

CREATE TABLE `directores` (
  `id` int(11) NOT NULL,
  `nombre_director` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `directores`
--

INSERT INTO `directores` (`id`, `nombre_director`) VALUES
(1, 'J. J. Abrams'),
(2, 'David Lynch'),
(3, 'Martin Scorsese'),
(4, 'Steven Soderbergh'),
(5, 'Quentin Tarantino'),
(6, 'Stanley Kubrick'),
(7, 'J. J. Abrams'),
(8, 'David Lynch'),
(9, 'Martin Scorsese'),
(10, 'Steven Soderbergh'),
(11, 'Quentin Tarantino'),
(12, 'Stanley Kubrick');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

CREATE TABLE `editoriales` (
  `id` int(11) NOT NULL,
  `nombre_editorial` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `editoriales`
--

INSERT INTO `editoriales` (`id`, `nombre_editorial`) VALUES
(1, 'Editorial Santillana'),
(2, 'ESE EDICIONES'),
(3, 'Editorial Jurídica Salvadoreña'),
(4, 'Libros La Ceiba'),
(5, 'Montañas de Fuego Internacional'),
(6, 'Editorial Santillana'),
(7, 'ESE EDICIONES'),
(8, 'Editorial Jurídica Salvadoreña'),
(9, 'Libros La Ceiba'),
(10, 'Montañas de Fuego Internacional');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `id` int(11) NOT NULL,
  `nombre_genero` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id`, `nombre_genero`) VALUES
(1, 'Suspenso'),
(2, 'Acción'),
(3, 'Drama'),
(4, 'Infantil'),
(5, 'Familiar'),
(6, 'pop rock'),
(7, 'Rock'),
(8, 'Suspenso'),
(9, 'Acción'),
(10, 'Drama'),
(11, 'Infantil'),
(12, 'Familiar'),
(13, 'pop rock'),
(14, 'Rock');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `id` varchar(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `codigo_tipo_material` int(11) NOT NULL,
  `codigo_autor` int(11) DEFAULT NULL,
  `numero_de_paginas` varchar(4) DEFAULT NULL,
  `codigo_editorial` int(11) DEFAULT NULL,
  `isbn` varchar(13) DEFAULT NULL,
  `periodicidad` varchar(15) DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `codigo_artista` int(11) DEFAULT NULL,
  `codigo_genero` int(11) DEFAULT NULL,
  `duracion` varchar(15) DEFAULT NULL,
  `numero_de_canciones` varchar(2) DEFAULT NULL,
  `codigo_director` int(11) DEFAULT NULL,
  `ubicacion` varchar(100) DEFAULT NULL,
  `nombre_autor_CV` varchar(150) DEFAULT NULL,
  `unidades_disponibles` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`id`, `titulo`, `codigo_tipo_material`, `codigo_autor`, `numero_de_paginas`, `codigo_editorial`, `isbn`, `periodicidad`, `fecha_publicacion`, `codigo_artista`, `codigo_genero`, `duracion`, `numero_de_canciones`, `codigo_director`, `ubicacion`, `nombre_autor_CV`, `unidades_disponibles`) VALUES
('LIB00001', 'Harry Potter', 4, 10, '600', 9, '9780747532699', NULL, '1997-06-26', NULL, NULL, NULL, NULL, NULL, 'Estante 3', NULL, 20),
('LIB00002', 'Hamlet', 4, 1, '500', 6, '1234567891234', NULL, '2008-06-15', NULL, NULL, NULL, NULL, NULL, 'Estante 2', NULL, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id` int(11) NOT NULL,
  `codigo_material` varchar(10) NOT NULL,
  `codigo_usuario` int(11) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol` varchar(75) NOT NULL,
  `numero_prestamos` int(11) NOT NULL,
  `dias_prestamo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol`, `numero_prestamos`, `dias_prestamo`) VALUES
(1, 'Administrador', 6, 99),
(2, 'Profesor', 3, 7),
(3, 'Alumno', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_material`
--

CREATE TABLE `tipo_material` (
  `id` int(11) NOT NULL,
  `tipo_material` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_material`
--

INSERT INTO `tipo_material` (`id`, `tipo_material`) VALUES
(1, 'CD'),
(2, 'DVD'),
(3, 'Revista'),
(4, 'Libro'),
(5, 'Obra'),
(6, 'Tesis');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `apellido` varchar(150) DEFAULT NULL,
  `nickname` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pass` varchar(200) NOT NULL,
  `mora` float DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `codigo_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `nickname`, `email`, `pass`, `mora`, `fecha_nacimiento`, `codigo_rol`) VALUES
(1, 'Francisco', 'Cartagena', 'JC240124', 'jc240124@udb.edu.sv', '123456', 0, '1992-02-15', 1),
(2, 'Betsy', 'Gomez', 'GJ240424', 'gj240424@udb.edu.sv', '123456', 0, '1990-10-10', 3),
(3, 'Patricia', 'Ruiz', 'RA240040', 'ra240040@udb.edu.sv', '123456', 0, '1995-01-01', 2),
(4, 'Bryan', 'Argueta', 'AH150281', 'ah150281@udb.edu.sv', '123456', 0, '1992-02-15', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `directores`
--
ALTER TABLE `directores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Tipo` (`codigo_tipo_material`),
  ADD KEY `FK_Autor` (`codigo_autor`),
  ADD KEY `FK_Editorial_id` (`codigo_editorial`),
  ADD KEY `FK_Artista` (`codigo_artista`),
  ADD KEY `FK_Genero` (`codigo_genero`),
  ADD KEY `FK_Director` (`codigo_director`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_usuario` (`codigo_usuario`),
  ADD KEY `FK_material_id` (`codigo_material`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Rol` (`codigo_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `autores`
--
ALTER TABLE `autores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `directores`
--
ALTER TABLE `directores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD CONSTRAINT `FK_Artista` FOREIGN KEY (`codigo_artista`) REFERENCES `artistas` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Autor` FOREIGN KEY (`codigo_autor`) REFERENCES `autores` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Director` FOREIGN KEY (`codigo_director`) REFERENCES `directores` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Editorial` FOREIGN KEY (`codigo_editorial`) REFERENCES `editoriales` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Genero` FOREIGN KEY (`codigo_genero`) REFERENCES `generos` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Tipo` FOREIGN KEY (`codigo_tipo_material`) REFERENCES `tipo_material` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `FK_Materiales` FOREIGN KEY (`codigo_material`) REFERENCES `materiales` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_Rol` FOREIGN KEY (`codigo_rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
