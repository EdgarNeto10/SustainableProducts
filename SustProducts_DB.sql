-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 08-Dez-2020 às 00:48
-- Versão do servidor: 8.0.13-4
-- versão do PHP: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pK1MWwLZ56`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `Carrinhos`
--

CREATE TABLE `Carrinhos` (
  `Carr_id` int(30) NOT NULL,
  `Carr_quant_prod` int(50) DEFAULT NULL,
  `Carr_precoTotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE `categorias` (
  `Cat_id` int(11) NOT NULL,
  `Cat_nome` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `Cli_id` int(30) NOT NULL,
  `Cli_tipoCartao` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cli_numCartao` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `encomendas`
--

CREATE TABLE `encomendas` (
  `Enc_id` int(30) NOT NULL,
  `Enc_dataEnvio` date DEFAULT NULL,
  `Enc_localEntrega` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Enc_estado` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Enc_precoPorte` double DEFAULT NULL,
  `Enc_precoTotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentos`
--

CREATE TABLE `pagamentos` (
  `Pag_id` int(30) NOT NULL,
  `Pag_tipo` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pag_numCartao` int(30) DEFAULT NULL,
  `Pag_data` date DEFAULT NULL,
  `Pag_totalCompra` double DEFAULT NULL,
  `Pag_nomeCliente` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `Prod_id` int(30) NOT NULL,
  `Prod_nome` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prod_preco` double DEFAULT NULL,
  `Prod_marca` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`Prod_id`, `Prod_nome`, `Prod_preco`, `Prod_marca`) VALUES
(1, 'sapato', 12.5, 'nike'),
(2, 'sapato', 14.7, 'adidas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Stocks`
--

CREATE TABLE `Stocks` (
  `Stock_id` int(30) NOT NULL,
  `Stock_quant_prod` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `utilizadores`
--

CREATE TABLE `utilizadores` (
  `Uti_id` int(30) NOT NULL,
  `Uti_nome` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_dataNac` date DEFAULT NULL,
  `Uti_morada` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_sexo` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedores`
--

CREATE TABLE `vendedores` (
  `vend_id` int(30) NOT NULL,
  `vend_cargo` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Carrinhos`
--
ALTER TABLE `Carrinhos`
  ADD PRIMARY KEY (`Carr_id`);

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`Cat_id`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`Cli_id`);

--
-- Indexes for table `encomendas`
--
ALTER TABLE `encomendas`
  ADD PRIMARY KEY (`Enc_id`);

--
-- Indexes for table `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD PRIMARY KEY (`Pag_id`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`Prod_id`);

--
-- Indexes for table `Stocks`
--
ALTER TABLE `Stocks`
  ADD PRIMARY KEY (`Stock_id`);

--
-- Indexes for table `utilizadores`
--
ALTER TABLE `utilizadores`
  ADD PRIMARY KEY (`Uti_id`);

--
-- Indexes for table `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`vend_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Carrinhos`
--
ALTER TABLE `Carrinhos`
  MODIFY `Carr_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `Cat_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `Cli_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `encomendas`
--
ALTER TABLE `encomendas`
  MODIFY `Enc_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pagamentos`
--
ALTER TABLE `pagamentos`
  MODIFY `Pag_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `Prod_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Stocks`
--
ALTER TABLE `Stocks`
  MODIFY `Stock_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `utilizadores`
--
ALTER TABLE `utilizadores`
  MODIFY `Uti_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `vend_id` int(30) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
