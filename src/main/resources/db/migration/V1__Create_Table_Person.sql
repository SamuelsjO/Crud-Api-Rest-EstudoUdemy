-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21/08/2019 às 02:19
-- Versão do servidor: 10.1.40-MariaDB
-- Versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `rest_with_spring_udemy`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `first_name` varchar(80) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `last_name` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `person`
--

INSERT INTO `person` (`id`, `address`, `first_name`, `gender`, `last_name`) VALUES
(1, 'Serranopolis - MG Minas', 'Nathila', 'Female', 'Vitoria'),
(2, 'Serranopolis - MG', 'Test', 'Female', 'Test');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `person`
--
ALTER TABLE `person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
