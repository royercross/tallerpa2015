-- phpMyAdmin SQL Dump
-- version 4.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-04-2015 a las 18:17:22
-- Versión del servidor: 5.5.38
-- Versión de PHP: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int(11) NOT NULL,
  `clave` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` char(32) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `clave`, `nombre`, `direccion`, `email`, `telefono`, `usuario`, `password`, `fecha_registro`, `fecha_eliminado`) VALUES
(1, 1, '1 modificado', '1', '1', '1', '1', '1', '2015-03-11 17:09:17', '2015-03-13 10:27:23'),
(2, 1000, 'Rogelio', 'Alarcon', 'rogelio', '1919191919', 'rogelio', 'rogelio', '2015-03-11 17:27:34', NULL),
(3, 1000, 'Rogelio Alfonso Noris Covarrubias', 'Alarcon', 'rogelio', '1919191919', 'rogelio', '8fc52b933532f9a4b83206ea5fd0d6c2', '2015-03-12 17:15:00', NULL),
(4, 1, 'modificado', '1', '1', '1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2015-03-12 17:32:34', NULL),
(5, 1, 'modificado', '1', '1', '1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2015-03-12 17:33:23', NULL),
(6, 1, 'modificado', '1', '1', '1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2015-03-12 17:33:57', NULL),
(7, 1, 'modificado', '1', '1', '1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2015-03-12 17:34:36', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL,
  `producto` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `fecha_eliminado` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `producto`, `precio`, `fecha_eliminado`) VALUES
(1, 'mac', 10000, NULL),
(2, 'mouse', 100, NULL),
(3, 'teclado', 1000, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `monto_total` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `folio`, `monto_total`, `fecha`) VALUES
(1, 100, 20100, '2015-04-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas_detalle`
--

CREATE TABLE IF NOT EXISTS `ventas_detalle` (
  `id` int(11) NOT NULL,
  `id_ventas` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` float NOT NULL,
  `id_descuentos` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas_detalle`
--

INSERT INTO `ventas_detalle` (`id`, `id_ventas`, `id_producto`, `precio`, `cantidad`, `total`, `id_descuentos`) VALUES
(1, 1, 1, 10000, 2, 20000, 0),
(2, 1, 2, 100, 1, 100, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas_detalle`
--
ALTER TABLE `ventas_detalle`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `ventas_detalle`
--
ALTER TABLE `ventas_detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
