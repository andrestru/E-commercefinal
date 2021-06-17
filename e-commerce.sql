-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 02:26:46
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `e-commerce`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `Number_order` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Identification` int(11) NOT NULL,
  `OrderStatus` varchar(10) NOT NULL,
  `Description` longtext NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`Number_order`, `Name`, `Address`, `Identification`, `OrderStatus`, `Description`, `total`) VALUES
('9D79BF48-A30D-413A', 'andres trujillo acosta', 'cra 38', 890, 'Pending', ' Product with id number: 5 and name: Nevera Haceb; \n', 950000),
('B6F7BE90-1E87-4A40', 'michael andres trujillo acosta', 'Medellin', 890, 'Approved', ' Product with id number: 3 and name: Xiaomi Note 9; \n Product with id number: 53 and name: Iphone 12 Pro Max; \n', 4600000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `Idp` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Description` varchar(280) NOT NULL,
  `BasePrice` decimal(10,0) NOT NULL,
  `TaxRate` double NOT NULL,
  `ProductStatus` varchar(10) DEFAULT NULL,
  `InventoryQuantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`Idp`, `ProductId`, `Name`, `Description`, `BasePrice`, `TaxRate`, `ProductStatus`, `InventoryQuantity`) VALUES
(238495244, 6, 'Plan Microsoft 365', '15 meses', '225650', 0.3, 'Published', 8),
(303686045, 7, 'Huawei mate 20', '128Gb', '1100000', 0.23, 'Published', 2),
(350303235, 2, 'Xiaomi Note 9', '128gb Gris', '850000', 0.3, 'Published', 3),
(393274934, 4, 'Televisor Samsung', '43 pulgadas', '1750000', 0.02, 'Rough_copy', 2),
(656175462, 3, 'Iphone 12 Pro Max', '256Gb', '4300000', 0.2, 'Published', 4),
(903526919, 5, 'Nevera Haceb', '12L', '950000', 0.2, 'Published', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `email`, `password`) VALUES
(1, 'andrestrujillo@gmail.com', '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Number_order`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Idp`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
