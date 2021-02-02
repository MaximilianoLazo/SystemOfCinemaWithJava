-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-11-2020 a las 14:49:09
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `misistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `dni_cliente` varchar(13) NOT NULL,
  `datos_cliente` varchar(100) NOT NULL,
  `contacto_cliente` varchar(50) NOT NULL,
  `puntos_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `dni_cliente`, `datos_cliente`, `contacto_cliente`, `puntos_cliente`) VALUES
(1, '27-39265127-0', 'Maximiliano Lazo', '15507934', 300),
(2, '20-33317889-5', 'Maxi Lazo', '426211', 675),
(4, '20-39265127-0', 'Miguel Lazo', '3444507934', 410),
(6, '27-18104422-3', 'FabianaGrasso', '426211', 155),
(7, '27-13997547-8', 'Bocha', '3444573457', 150),
(8, '20-15689352-3', 'Tabares Vazquez', '3444526585', 0),
(9, '27-30322145-5', 'Maximiliano lazoo', '426211', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE IF NOT EXISTS `entradas` (
  `id_entradas` int(5) NOT NULL AUTO_INCREMENT,
  `entradas_precio` int(5) NOT NULL,
  PRIMARY KEY (`id_entradas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `entradas`
--

INSERT INTO `entradas` (`id_entradas`, `entradas_precio`) VALUES
(1, 80),
(2, 150),
(3, 110);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menores`
--

CREATE TABLE IF NOT EXISTS `menores` (
  `menores_precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE IF NOT EXISTS `peliculas` (
  `id_peli` int(100) NOT NULL AUTO_INCREMENT,
  `nombre_peli` varchar(100) NOT NULL,
  `formato_peli` varchar(5) NOT NULL,
  `genero_peli` varchar(30) NOT NULL,
  `idioma_peli` varchar(30) NOT NULL,
  PRIMARY KEY (`id_peli`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id_peli`, `nombre_peli`, `formato_peli`, `genero_peli`, `idioma_peli`) VALUES
(1, 'Chuky 2', '3D', 'Terror', 'Latino'),
(2, 'Viernes 13', '2D', 'Terror', 'Latino'),
(3, 'El conjuro 2', '3D', 'Terror', 'Subtitulos Español'),
(4, 'Ted 2', '3D', 'Comedia', 'Latino'),
(5, 'Anabelle vuelve', '3D', 'Terror', 'Subtitulos Español'),
(6, 'Terminator', '2D', 'Acción', 'Latino'),
(7, 'El transportador', '2D', 'Acción', 'Latino'),
(8, 'Rambo 4', '2D', 'Acción', 'Inglés'),
(9, 'Rapidos y furiosos 8', '3D', 'Acción', 'Latino'),
(10, 'Kun fu Panda', '3D', 'Animada', 'Latino'),
(11, 'Jurasik Park 3', '3D', 'Aventuras', 'Latino'),
(12, 'jurasik park 4', '3D', 'Aventuras', 'Subtitulos Español');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `probando`
--

CREATE TABLE IF NOT EXISTS `probando` (
  `id_algo` int(11) NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  PRIMARY KEY (`id_algo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id_pro` varchar(255) NOT NULL,
  `producto` varchar(255) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_pro`, `producto`, `precio`) VALUES
('p001', 'lavandina ayudin', 35),
('p002', 'Detergente Ala', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservaciones`
--

CREATE TABLE IF NOT EXISTS `reservaciones` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservaciones`
--

INSERT INTO `reservaciones` (`sala`, `id_butaca`, `reservado`) VALUES
('A', 1, 'si'),
('A', 2, 'no'),
('A', 3, 'no'),
('A', 4, 'no'),
('A', 5, 'no'),
('A', 6, 'no'),
('A', 7, 'no'),
('A', 8, 'no'),
('A', 9, 'no'),
('A', 10, 'no'),
('A', 11, 'no'),
('A', 12, 'no'),
('A', 13, 'no'),
('A', 14, 'no'),
('A', 15, 'no'),
('A', 16, 'no'),
('A', 17, 'no'),
('A', 18, 'no'),
('A', 19, 'no'),
('A', 20, 'no'),
('A', 21, 'no'),
('A', 22, 'no'),
('A', 23, 'no'),
('A', 24, 'no'),
('A', 25, 'no'),
('A', 26, 'no'),
('A', 27, 'no'),
('A', 28, 'no'),
('A', 29, 'no'),
('A', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservaciones2a`
--

CREATE TABLE IF NOT EXISTS `reservaciones2a` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservaciones2a`
--

INSERT INTO `reservaciones2a` (`sala`, `id_butaca`, `reservado`) VALUES
('E', 1, 'no'),
('E', 2, 'no'),
('E', 3, 'no'),
('E', 4, 'no'),
('E', 5, 'no'),
('E', 6, 'no'),
('E', 7, 'no'),
('E', 8, 'no'),
('E', 9, 'no'),
('E', 10, 'no'),
('E', 11, 'no'),
('E', 12, 'no'),
('E', 13, 'no'),
('E', 14, 'no'),
('E', 15, 'no'),
('E', 16, 'no'),
('E', 17, 'no'),
('E', 18, 'no'),
('E', 19, 'no'),
('E', 20, 'no'),
('E', 21, 'no'),
('E', 22, 'no'),
('E', 23, 'no'),
('E', 24, 'no'),
('E', 25, 'no'),
('E', 26, 'no'),
('E', 27, 'no'),
('E', 28, 'no'),
('E', 29, 'no'),
('E', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservaciones2b`
--

CREATE TABLE IF NOT EXISTS `reservaciones2b` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservaciones2b`
--

INSERT INTO `reservaciones2b` (`sala`, `id_butaca`, `reservado`) VALUES
('F', 1, 'no'),
('F', 2, 'no'),
('F', 3, 'no'),
('F', 4, 'no'),
('F', 5, 'no'),
('F', 6, 'no'),
('F', 7, 'no'),
('F', 8, 'no'),
('F', 9, 'no'),
('F', 10, 'no'),
('F', 11, 'no'),
('F', 12, 'no'),
('F', 13, 'no'),
('F', 14, 'no'),
('F', 15, 'no'),
('F', 16, 'no'),
('F', 17, 'no'),
('F', 18, 'no'),
('F', 19, 'no'),
('F', 20, 'no'),
('F', 21, 'no'),
('F', 22, 'no'),
('F', 23, 'no'),
('F', 24, 'no'),
('F', 25, 'no'),
('F', 26, 'no'),
('F', 27, 'no'),
('F', 28, 'no'),
('F', 29, 'no'),
('F', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservaciones2c`
--

CREATE TABLE IF NOT EXISTS `reservaciones2c` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservaciones2c`
--

INSERT INTO `reservaciones2c` (`sala`, `id_butaca`, `reservado`) VALUES
('G', 1, 'no'),
('G', 2, 'no'),
('G', 3, 'no'),
('G', 4, 'no'),
('G', 5, 'no'),
('G', 6, 'no'),
('G', 7, 'no'),
('G', 8, 'no'),
('G', 9, 'no'),
('G', 10, 'no'),
('G', 11, 'no'),
('G', 12, 'no'),
('G', 13, 'no'),
('G', 14, 'no'),
('G', 15, 'no'),
('G', 16, 'no'),
('G', 17, 'no'),
('G', 18, 'no'),
('G', 19, 'no'),
('G', 20, 'no'),
('G', 21, 'no'),
('G', 22, 'no'),
('G', 23, 'no'),
('G', 24, 'no'),
('G', 25, 'no'),
('G', 26, 'no'),
('G', 27, 'no'),
('G', 28, 'no'),
('G', 29, 'no'),
('G', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservaciones2d`
--

CREATE TABLE IF NOT EXISTS `reservaciones2d` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservaciones2d`
--

INSERT INTO `reservaciones2d` (`sala`, `id_butaca`, `reservado`) VALUES
('H', 1, 'no'),
('H', 2, 'no'),
('H', 3, 'no'),
('H', 4, 'no'),
('H', 5, 'no'),
('H', 6, 'no'),
('H', 7, 'no'),
('H', 8, 'no'),
('H', 9, 'no'),
('H', 10, 'no'),
('H', 11, 'no'),
('H', 12, 'no'),
('H', 13, 'no'),
('H', 14, 'no'),
('H', 15, 'no'),
('H', 16, 'no'),
('H', 17, 'no'),
('H', 18, 'no'),
('H', 19, 'no'),
('H', 20, 'no'),
('H', 21, 'no'),
('H', 22, 'no'),
('H', 23, 'no'),
('H', 24, 'no'),
('H', 25, 'no'),
('H', 26, 'no'),
('H', 27, 'no'),
('H', 28, 'no'),
('H', 29, 'no'),
('H', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacionesb`
--

CREATE TABLE IF NOT EXISTS `reservacionesb` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservacionesb`
--

INSERT INTO `reservacionesb` (`sala`, `id_butaca`, `reservado`) VALUES
('B', 1, 'si'),
('B', 2, 'si'),
('B', 3, 'si'),
('B', 4, 'si'),
('B', 5, 'no'),
('B', 6, 'no'),
('B', 7, 'no'),
('B', 8, 'no'),
('B', 9, 'no'),
('B', 10, 'no'),
('B', 11, 'no'),
('B', 12, 'no'),
('B', 13, 'no'),
('B', 14, 'no'),
('B', 15, 'no'),
('B', 16, 'no'),
('B', 17, 'no'),
('B', 18, 'no'),
('B', 19, 'no'),
('B', 20, 'no'),
('B', 21, 'no'),
('B', 22, 'no'),
('B', 23, 'no'),
('B', 24, 'no'),
('B', 25, 'no'),
('B', 26, 'no'),
('B', 27, 'no'),
('B', 28, 'no'),
('B', 29, 'no'),
('B', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacionesc`
--

CREATE TABLE IF NOT EXISTS `reservacionesc` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservacionesc`
--

INSERT INTO `reservacionesc` (`sala`, `id_butaca`, `reservado`) VALUES
('C', 1, 'no'),
('C', 2, 'no'),
('C', 3, 'no'),
('C', 4, 'no'),
('C', 5, 'no'),
('C', 6, 'no'),
('C', 7, 'no'),
('C', 8, 'no'),
('C', 9, 'no'),
('C', 10, 'no'),
('C', 11, 'no'),
('C', 12, 'no'),
('C', 13, 'no'),
('C', 14, 'no'),
('C', 15, 'no'),
('C', 16, 'no'),
('C', 17, 'no'),
('C', 18, 'no'),
('C', 19, 'no'),
('C', 20, 'no'),
('C', 21, 'no'),
('C', 22, 'no'),
('C', 23, 'no'),
('C', 24, 'no'),
('C', 25, 'no'),
('C', 26, 'no'),
('C', 27, 'no'),
('C', 28, 'no'),
('C', 29, 'no'),
('C', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacionesd`
--

CREATE TABLE IF NOT EXISTS `reservacionesd` (
  `sala` varchar(50) NOT NULL,
  `id_butaca` int(11) NOT NULL AUTO_INCREMENT,
  `reservado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_butaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `reservacionesd`
--

INSERT INTO `reservacionesd` (`sala`, `id_butaca`, `reservado`) VALUES
('D', 1, 'si'),
('D', 2, 'si'),
('D', 3, 'si'),
('D', 4, 'no'),
('D', 5, 'no'),
('D', 6, 'no'),
('D', 7, 'no'),
('D', 8, 'no'),
('D', 9, 'no'),
('D', 10, 'no'),
('D', 11, 'no'),
('D', 12, 'no'),
('D', 13, 'no'),
('D', 14, 'no'),
('D', 15, 'no'),
('D', 16, 'no'),
('D', 17, 'no'),
('D', 18, 'no'),
('D', 19, 'no'),
('D', 20, 'no'),
('D', 21, 'no'),
('D', 22, 'no'),
('D', 23, 'no'),
('D', 24, 'no'),
('D', 25, 'no'),
('D', 26, 'no'),
('D', 27, 'no'),
('D', 28, 'no'),
('D', 29, 'no'),
('D', 30, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE IF NOT EXISTS `tienda` (
  `id_puntos` int(11) NOT NULL AUTO_INCREMENT,
  `objeto` varchar(100) NOT NULL,
  `puntos` int(50) NOT NULL,
  PRIMARY KEY (`id_puntos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`id_puntos`, `objeto`, `puntos`) VALUES
(1, 'entrada menor', 5000),
(2, 'entrada mayor', 7750),
(3, 'entrada jubilado', 6000),
(4, 'Mascára de Chucky', 10000),
(6, 'Pochoclos chicos', 1500),
(7, 'Llavero de minion', 700),
(8, 'Pochoclos medianos', 2500),
(9, 'agua mineral', 200),
(10, 'coca cola', 150);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE IF NOT EXISTS `tipousuario` (
  `id_tipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `tipoUsuario` varchar(10) NOT NULL,
  PRIMARY KEY (`id_tipoUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`id_tipoUsuario`, `tipoUsuario`) VALUES
(1, 'Jefe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(15) NOT NULL,
  `Contrasenia` varchar(100) NOT NULL,
  `id_tipoUsuario` varchar(12) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `Usuario`, `Contrasenia`, `id_tipoUsuario`) VALUES
(2, 'maxi', '81f6e7f8b8b787f57d5dccf6ac682ffae65ff2f2', 'Jefe'),
(13, 'empleado', 'f9f011a553550aef31a8ee2690e1d1b5f261c9ff', 'Empleado'),
(14, 'jefes', 'a7434f460c6827fd280bc540f309c25003a50ef4', 'Jefe'),
(15, 'maxim', 'f63b096a3073587a26e0e10999a60c7efd3293f7', 'Jefe'),
(16, 'cinema', '2ffb113581e4a6d7250adc4c456c7c38179e20a2', 'Empleado'),
(17, 'diego', '8becd72c81a5b0e1f4fd0b2dbbb5c76fc4c579f4', 'Jefe'),
(18, 'mama', 'f722f20fc568981ad1702f8075048e08a766bfa0', 'Empleado'),
(19, 'juan', 'b49a5780a99ea81284fc0746a78f84a30e4d5c73', 'Empleado'),
(20, 'cami', '281ed25a21e42a374384b0304fd0a6dd247b49d7', 'Empleado'),
(21, 'mouse', 'aa01b7ef71469ace213ad55b49d2b6123a60b435', 'Empleado'),
(22, 'usuario', 'b665e217b51994789b02b1838e730d6b93baa30f', 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `id_venta` int(100) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `venta_precio` int(10) NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `fecha`, `venta_precio`) VALUES
(1, '2020-11-11', 500),
(2, '2020-11-16', 350),
(3, '2020-11-17', 270);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_venta` date NOT NULL,
  `cuit_venta` varchar(13) NOT NULL,
  `hinicio_venta` varchar(5) NOT NULL,
  `pelicula_venta` varchar(100) NOT NULL,
  `form_venta` varchar(2) NOT NULL,
  `ubi_venta` varchar(60) NOT NULL,
  `total_venta` int(10) NOT NULL,
  `codigo_venta` int(10) NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `fecha_venta`, `cuit_venta`, `hinicio_venta`, `pelicula_venta`, `form_venta`, `ubi_venta`, `total_venta`, `codigo_venta`) VALUES
(1, '2020-11-29', '20-39265127-7', '20:00', 'Chucky 3', '3D', '-6-8-9-10', 400, 0),
(2, '2020-11-29', '27-13997547-8', '20:00', 'Viernes 13', '2D', '-2-4', 150, 88752019),
(3, '2020-11-29', '27-18104422-3', '20:00', 'Viernes 13', '2D', '-11-5', 185, 42156208),
(4, '2020-11-29', '20-39265127-7', '22:00', 'Chuky 2', '3D', '-2-3-4-5', 450, 450),
(5, '2020-11-29', '27-18104422-3', '22:55', 'Ted 2', '3D', '-8', 75, 75),
(6, '2020-11-29', '27-13997547-8', '22:00', 'Anabelle vuelve', '3D', '-9-10', 0, 0),
(7, '2020-11-29', '27-18104422-3', '22:00', 'El conjuro 3', '3D', '-7-11', 150, 28308700),
(8, '2020-11-29', '27-18104422-3', '22:00', 'El transportador', '2D', '-2-3-4', 335, 51059876),
(9, '2020-11-29', '27-18104422-3', '22:50', 'Rambo 3', '2D', '-5-4-3', 375, 46746906),
(10, '2020-11-29', '27-18104422-3', '22:00', 'Rambo 3', '2D', '-1-2-3', 370, 76347611),
(11, '2020-11-29', '27-13997547-8', '22:00', 'Rapidos y furiosos 8', '3D', '-1-2-3', 450, 11073338),
(12, '2020-11-29', '27-18104422-3', '23:30', 'Rambo 3', '2D', '-7-14', 300, 31889086),
(13, '2020-11-29', '27-18104422-3', '22:00', 'Terminator', '2D', '-2', 75, 82738848),
(14, '2020-11-29', '27-18104422-3', '20:00', 'El transportador', '2D', '-2-1-3-4', 600, 88593311),
(15, '2020-11-29', '20-39265127-7', '20:00', 'Chuky 2', '3D', '-9-8', 150, 30554541),
(16, '2020-11-29', '20-39265127-7', '20:00', 'Chuky 2', '3D', '-8-9', 260, 51588260),
(17, '2020-11-29', '20-33317889-5', '20:00', 'Chuky 2', '3D', '-8-3', 150, 48947840),
(18, '2020-11-29', '27-18104422-3', '20:00', 'El transportador', '2D', '-10-11', 300, 81786094),
(19, '2020-11-29', '20-33317889-5', '23:55', 'Chuky 2', '3D', '-3-2', 150, 430270),
(20, '2020-11-30', '27-18104422-3', '20:00', 'Anabelle vuelve', '3D', '-9-8', 300, 87176294),
(21, '2020-11-30', '27-39265127-0', '20:00', 'El transportador', '2D', '-2-1', 300, 80980708),
(22, '2020-11-30', '27-18104422-3', '23:00', 'Anabelle vuelve', '3D', '-10-11-5-12-16', 750, 44217302),
(23, '2020-11-30', '27-13997547-8', '20:00', 'El transportador', '2D', '-2-1-3-4', 600, 75076959),
(24, '2020-11-30', '27-18104422-3', '07:00', 'El conjuro 2', '3D', '-2-1-3', 450, 75735389),
(25, '2020-11-30', '20-33317889-5', '20:00', 'Jurasik Park 3', '3D', '-2-3-4', 450, 20523373);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
