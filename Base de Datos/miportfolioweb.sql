-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-04-2022 a las 01:39:48
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `miportfolioweb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `idExperiencia` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `periodo` varchar(45) NOT NULL,
  `logo` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `experiencia`
--

INSERT INTO `experiencia` (`idExperiencia`, `titulo`, `periodo`, `logo`, `descripcion`) VALUES
(1, 'Jefe de Informática', 'Abr 2020 - continúa', '/assets/images/LogoHospital50.png', 'Hospital Regional Diego Paroissien. Desarrollo de Sitio Web de Consulta de Camas Disponibles, Cronograma de Quirófanos y Otros. HTML, CSS, PHP, MySQL'),
(2, 'Wordpress Freelance', '2016 - 2019', '/assets/images/logoWordpress.png', 'Sitios Web con Wordpress: Coro de la Ciudad de Mendoza, Clínica Mira, Viviendas el Trébol. Sitio Web con Google Sites: Aleksei Abutkov'),
(3, 'Administrador de Sistemas', 'Set 2006 - Abr 2020', '/assets/images/logoGobMza.png', 'Administración de Servidores. Administración del Sitio Web www.desarrollosocial.mendoza.gov.ar, en Joomla y luego Wordpress. Líder de Proyecto de Implementación del sistema Gestión Documental Electrónica.'),
(4, 'Capacitador Microsoft Excel y Access, Google ', 'May 2005 - Nov 2014', '/assets/images/logoExcel.png', 'Dicté cursos de Excel y Access en Centro de Capacitación de Extensión Universitaria de la UTN Regional Mendoza, y en Educación Mendoza Training Center. También dicté el curso de Google Apps al personal de la Bodega Monteviejo.'),
(5, '\"Profesor de Informática', 'Mar 1997 - Jun 2008', '/assets/images/logoEscuela.png', 'Fui profe de Informática en Colegio Universitario del Aconcagua, Instituto Nadino (primaria y secundaria), Instituto Terciario Nuevo Cuyo e Instituto de la Sanidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formacion`
--

CREATE TABLE `formacion` (
  `idFormacion` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `periodo` varchar(45) NOT NULL,
  `logo` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `formacion`
--

INSERT INTO `formacion` (`idFormacion`, `titulo`, `periodo`, `logo`, `descripcion`) VALUES
(1, 'Full Stack Angular, Java, Spring Boot, MySQL,', 'Nov 2021 - May 2022', '/assets/images/logoArgentinaPrograma.png', 'Argentina Programa - Modalidad: A distancia - 360 hs.'),
(2, 'Especialización en Desarrollo Mobile', 'Set - Nov 2021', '/assets/images/logoCaC.jpg', 'Codo a Codo 4.0 - Buenos Aires Ciudad. UX/UI, React Native, MongoDB, NodeJS - Modalidad: A distancia Autoasistido - 60 hs.'),
(3, 'Full Stack HTML, CSS, JavaScript, PHP, MySQL', 'Ago - Dic 2020', '/assets/images/logoCaC.jpg', 'Codo a Codo 4.0 - Buenos Aires Ciudad. Modalidad: A distancia - 66 hs.'),
(4, 'Administración de Bases de Datos Relacionales', 'Mar - Ago 2010', '/assets/images/logoUtn.jpg', 'U.T.N. Regional Mendoza - Proydesa - Becas Control+F. Oracle 9i DBA Niveles Inicial, Intermedio y Avanzado. 240 hs.'),
(5, 'Microsoft Certified System Administrator', 'Set 2005', '/assets/images/logoExo.jpg', 'EXO Training Center - Buenos Aires. Administración de Servidores con Windows 2003 Server, clientes Windows XP e ISA Server 2000. Fast Track 120 hs.'),
(6, 'Licenciado en Sistemas de Información', '1992 - 1999', '/assets/images/logoUM.jpg', 'Facultad de Ingeniería - Universidad de Mendoza'),
(7, 'Bachiller y Perito Mercantil', '1985 - 1990', '/assets/images/logoSTA.png', 'Colegio Santo Tomás de Aquino. Primer escolta de Bandera Nacional'),
(8, 'Nivel Primario', '1977 - 1984', '/assets/images/logoNadino.png', 'Instituto Nadino. Abanderado Bandera Nacional');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidades`
--

CREATE TABLE `habilidades` (
  `idHabilidades` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `porcentaje` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `habilidades`
--

INSERT INTO `habilidades` (`idHabilidades`, `nombre`, `porcentaje`) VALUES
(1, 'HTML5', '[80,20]'),
(2, 'CSS3', '[70,30]'),
(3, 'JavaScript', '[60,40]'),
(4, 'PHP', '[50,50]'),
(5, 'MySQL', '[60,40]'),
(6, 'Angular', '[30,70]'),
(7, 'Java', '[20,80]'),
(8, 'Spring Boot', '[20,80]'),
(9, 'Dev Ops', '[20,80]'),
(10, 'React Native', '[30,70]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idiomas`
--

CREATE TABLE `idiomas` (
  `idIdiomas` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `idiomas`
--

INSERT INTO `idiomas` (`idIdiomas`, `nombre`, `imagen`, `descripcion`) VALUES
(1, 'Inglés', '', '6 años en el colegio secundario, 2 años intensivos en Instituto. Inglés técnico en la facultad. Leo bien, hablo regular'),
(2, 'Francés', '', '4 años en el colegio secundario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `intereses`
--

CREATE TABLE `intereses` (
  `idIntereses` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `intereses`
--

INSERT INTO `intereses` (`idIntereses`, `nombre`, `imagen`, `descripcion`) VALUES
(1, 'Estudiar programación', '', 'Siempre se puede mejorar'),
(2, 'Canto Coral', '', 'Integro el Coro de la Ciudad de Mendoza desde'),
(3, 'Squash', '', 'Juego con amigos 1 o 2 veces por semana'),
(4, 'Fútbol', '', 'Juego los sábados con mis amigos'),
(5, 'Cine y series en familia', '', 'Con mi hija y mi pareja'),
(6, 'Viajes', '', 'Chile, Perú, Ecuador, Costa Rica, Cuba, Españ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `foto` varchar(45) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `sobreMi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `apellido`, `nombre`, `foto`, `titulo`, `ubicacion`, `sobreMi`) VALUES
(1, 'Llopiz', 'Norberto', '', 'Full Stack Developer Jr', 'Mendoza, Argentina', 'Soy Licenciado en Sistemas, me dedico a brindar soluciones informáticas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_conoce_idiomas`
--

CREATE TABLE `persona_conoce_idiomas` (
  `persona_idPersona` int(11) NOT NULL,
  `idiomas_idIdiomas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_conoce_idiomas`
--

INSERT INTO `persona_conoce_idiomas` (`persona_idPersona`, `idiomas_idIdiomas`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_participaen_proyectos`
--

CREATE TABLE `persona_participaen_proyectos` (
  `persona_idPersona` int(11) NOT NULL,
  `proyectos_idProyectos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_participaen_proyectos`
--

INSERT INTO `persona_participaen_proyectos` (`persona_idPersona`, `proyectos_idProyectos`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_tiene_experiencia`
--

CREATE TABLE `persona_tiene_experiencia` (
  `persona_idPersona` int(11) NOT NULL,
  `experiencia_idExperiencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_tiene_experiencia`
--

INSERT INTO `persona_tiene_experiencia` (`persona_idPersona`, `experiencia_idExperiencia`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_tiene_formacion`
--

CREATE TABLE `persona_tiene_formacion` (
  `persona_idPersona` int(11) NOT NULL,
  `formacion_idFormacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_tiene_formacion`
--

INSERT INTO `persona_tiene_formacion` (`persona_idPersona`, `formacion_idFormacion`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_tiene_habilidades`
--

CREATE TABLE `persona_tiene_habilidades` (
  `persona_idPersona` int(11) NOT NULL,
  `habilidades_idHabilidades` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_tiene_habilidades`
--

INSERT INTO `persona_tiene_habilidades` (`persona_idPersona`, `habilidades_idHabilidades`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_tiene_intereses`
--

CREATE TABLE `persona_tiene_intereses` (
  `persona_idPersona` int(11) NOT NULL,
  `intereses_idIntereses` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_tiene_intereses`
--

INSERT INTO `persona_tiene_intereses` (`persona_idPersona`, `intereses_idIntereses`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `idProyectos` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `link` varchar(45) DEFAULT NULL,
  `github` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`idProyectos`, `titulo`, `imagen`, `descripcion`, `link`, `github`) VALUES
(1, 'Mi Portfolio Web', '/assets/images/imgPortfolio.jpg', 'Angular, Java, Spring Boot, MySQL, Dev Ops', NULL, NULL),
(2, 'Información Asistencial', '/assets/images/imgCamas.jpg', 'HTML5, CSS3, Bootstrap, PHP, Lectura de tablas DBF de un sistema Visual Fox.', 'http://190.15.207.250:8082/infoAsistencial/ca', NULL),
(3, 'Marcaciones del Personal', '/assets/images/imgMarcaciones.jpg', 'HTML5, CSS3, Bootstrap, PHP, Lectura de archivo Access.', 'http://190.15.207.250:8082/marcaciones', NULL),
(4, 'Viviendas El Trébol', '/assets/images/imgTrebol.jpg', 'Wordpress', 'http://www.eltrebolviviendas.com.ar', NULL),
(5, 'Coro de la Ciudad de Mendoza', '/assets/images/imgCoro.jpg', 'Wordpress', 'http://www.corociudadmendoza.com.ar', NULL),
(6, 'Clínica Mira', '/assets/images/imgCMira.jpg', 'Wordpress', 'https://clinicamira.com.ar', NULL),
(7, 'Desarrollo Social - Gobierno de Mendoza', '/assets/images/imgDSocial.jpg', 'Wordpress', 'https://www.mendoza.gov.ar/desarrollosocial', NULL),
(8, 'EDICIÓN CRÍTICA DE LAS OBRAS DE ALEKSEI ABUTK', '', 'Google Sites', 'https://sites.google.com/view/aleksei-abutkov', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`idExperiencia`);

--
-- Indices de la tabla `formacion`
--
ALTER TABLE `formacion`
  ADD PRIMARY KEY (`idFormacion`);

--
-- Indices de la tabla `habilidades`
--
ALTER TABLE `habilidades`
  ADD PRIMARY KEY (`idHabilidades`);

--
-- Indices de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  ADD PRIMARY KEY (`idIdiomas`);

--
-- Indices de la tabla `intereses`
--
ALTER TABLE `intereses`
  ADD PRIMARY KEY (`idIntereses`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `persona_conoce_idiomas`
--
ALTER TABLE `persona_conoce_idiomas`
  ADD PRIMARY KEY (`persona_idPersona`,`idiomas_idIdiomas`),
  ADD KEY `fk_persona_has_idiomas_idiomas1` (`idiomas_idIdiomas`);

--
-- Indices de la tabla `persona_participaen_proyectos`
--
ALTER TABLE `persona_participaen_proyectos`
  ADD PRIMARY KEY (`persona_idPersona`,`proyectos_idProyectos`),
  ADD KEY `fk_persona_has_proyectos_proyectos1` (`proyectos_idProyectos`);

--
-- Indices de la tabla `persona_tiene_experiencia`
--
ALTER TABLE `persona_tiene_experiencia`
  ADD PRIMARY KEY (`persona_idPersona`,`experiencia_idExperiencia`),
  ADD KEY `fk_persona_has_experiencia_experiencia1` (`experiencia_idExperiencia`);

--
-- Indices de la tabla `persona_tiene_formacion`
--
ALTER TABLE `persona_tiene_formacion`
  ADD PRIMARY KEY (`persona_idPersona`,`formacion_idFormacion`),
  ADD KEY `fk_persona_has_formacion_formacion1` (`formacion_idFormacion`);

--
-- Indices de la tabla `persona_tiene_habilidades`
--
ALTER TABLE `persona_tiene_habilidades`
  ADD PRIMARY KEY (`persona_idPersona`,`habilidades_idHabilidades`),
  ADD KEY `fk_persona_has_habilidades_habilidades1` (`habilidades_idHabilidades`);

--
-- Indices de la tabla `persona_tiene_intereses`
--
ALTER TABLE `persona_tiene_intereses`
  ADD PRIMARY KEY (`persona_idPersona`,`intereses_idIntereses`),
  ADD KEY `fk_persona_has_intereses_intereses1` (`intereses_idIntereses`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`idProyectos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `idExperiencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `formacion`
--
ALTER TABLE `formacion`
  MODIFY `idFormacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `habilidades`
--
ALTER TABLE `habilidades`
  MODIFY `idHabilidades` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  MODIFY `idIdiomas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `intereses`
--
ALTER TABLE `intereses`
  MODIFY `idIntereses` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `idProyectos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `persona_conoce_idiomas`
--
ALTER TABLE `persona_conoce_idiomas`
  ADD CONSTRAINT `fk_persona_has_idiomas_idiomas1` FOREIGN KEY (`idiomas_idIdiomas`) REFERENCES `idiomas` (`idIdiomas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_persona_has_idiomas_persona1` FOREIGN KEY (`persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona_participaen_proyectos`
--
ALTER TABLE `persona_participaen_proyectos`
  ADD CONSTRAINT `fk_persona_has_proyectos_persona1` FOREIGN KEY (`persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_persona_has_proyectos_proyectos1` FOREIGN KEY (`proyectos_idProyectos`) REFERENCES `proyectos` (`idProyectos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona_tiene_experiencia`
--
ALTER TABLE `persona_tiene_experiencia`
  ADD CONSTRAINT `fk_persona_has_experiencia_experiencia1` FOREIGN KEY (`experiencia_idExperiencia`) REFERENCES `experiencia` (`idExperiencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_persona_has_experiencia_persona1` FOREIGN KEY (`persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona_tiene_formacion`
--
ALTER TABLE `persona_tiene_formacion`
  ADD CONSTRAINT `fk_persona_has_formacion_formacion1` FOREIGN KEY (`formacion_idFormacion`) REFERENCES `formacion` (`idFormacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_persona_has_formacion_persona1` FOREIGN KEY (`persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona_tiene_habilidades`
--
ALTER TABLE `persona_tiene_habilidades`
  ADD CONSTRAINT `fk_persona_has_habilidades_habilidades1` FOREIGN KEY (`habilidades_idHabilidades`) REFERENCES `habilidades` (`idHabilidades`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_persona_has_habilidades_persona1` FOREIGN KEY (`persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona_tiene_intereses`
--
ALTER TABLE `persona_tiene_intereses`
  ADD CONSTRAINT `fk_persona_has_intereses_intereses1` FOREIGN KEY (`intereses_idIntereses`) REFERENCES `intereses` (`idIntereses`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_persona_has_intereses_persona1` FOREIGN KEY (`persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
