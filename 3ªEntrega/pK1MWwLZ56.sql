-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 10-Jan-2021 às 23:03
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
-- Estrutura da tabela `carrinhos`
--

CREATE TABLE `carrinhos` (
  `Carr_id` int(30) NOT NULL,
  `Carr_quant_prod` int(50) DEFAULT NULL,
  `Carr_preco_total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `carrinhos`
--

INSERT INTO `carrinhos` (`Carr_id`, `Carr_quant_prod`, `Carr_preco_total`) VALUES
(3, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `carrinho_produtos`
--

CREATE TABLE `carrinho_produtos` (
  `carrprod_fk_carr` int(11) NOT NULL,
  `carrprod_fk_prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `carrinho_produtos`
--

INSERT INTO `carrinho_produtos` (`carrprod_fk_carr`, `carrprod_fk_prod`) VALUES
(3, 14),
(3, 15),
(3, 17);

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE `categorias` (
  `Cat_id` int(11) NOT NULL,
  `Cat_nome` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `categorias`
--

INSERT INTO `categorias` (`Cat_id`, `Cat_nome`) VALUES
(1, 'Higiene Oral'),
(2, 'Higiene Animal'),
(3, 'Limpeza'),
(4, 'Cosmétca'),
(5, 'Decoração'),
(6, 'Calcado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria_produtos`
--

CREATE TABLE `categoria_produtos` (
  `Cat_Prod_id` int(11) NOT NULL,
  `catprod_fk_cat` int(11) NOT NULL,
  `catprod_fk_prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Extraindo dados da tabela `categoria_produtos`
--

INSERT INTO `categoria_produtos` (`Cat_Prod_id`, `catprod_fk_cat`, `catprod_fk_prod`) VALUES
(14, 6, 17),
(15, 6, 14),
(16, 1, 15),
(17, 6, 17),
(18, 6, 14),
(19, 1, 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `Cli_id` int(30) NOT NULL,
  `Cli_tipo_Cartao` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cli_num_Cartao` int(30) DEFAULT NULL,
  `cli_fk_uti` int(24) NOT NULL,
  `cli_fk_carr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`Cli_id`, `Cli_tipo_Cartao`, `Cli_num_Cartao`, `cli_fk_uti`, `cli_fk_carr`) VALUES
(14, 'maestro', 2134242321, 1, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `encomendas`
--

CREATE TABLE `encomendas` (
  `Enc_id` int(30) NOT NULL,
  `Enc_data_Envio` date DEFAULT NULL,
  `Enc_local_Entrega` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Enc_estado` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Enc_preco_Porte` double DEFAULT NULL,
  `Enc_preco_Total` double DEFAULT NULL,
  `Enc_cli_id` int(11) DEFAULT NULL,
  `Enc_fk_carr` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `encomendas`
--

INSERT INTO `encomendas` (`Enc_id`, `Enc_data_Envio`, `Enc_local_Entrega`, `Enc_estado`, `Enc_preco_Porte`, `Enc_preco_Total`, `Enc_cli_id`, `Enc_fk_carr`) VALUES
(9, '2020-12-23', 'Paris', 'Nova', 12, 34.6, 14, 3),
(21, '2021-01-10', 'rua lima', 'Nova', 2.95, 2.95, NULL, NULL),
(22, '2021-01-10', 'rua lima', 'Nova', 2.95, 4.95, NULL, NULL),
(23, '2021-01-10', 'rua lima', 'Nova', 2.95, 20.45, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentos`
--

CREATE TABLE `pagamentos` (
  `Pag_id` int(30) NOT NULL,
  `Pag_tipo` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pag_num_cartao` int(30) DEFAULT NULL,
  `Pag_data` date DEFAULT NULL,
  `Pag_total_compra` double DEFAULT NULL,
  `Pag_nome_cliente` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `pagamentos`
--

INSERT INTO `pagamentos` (`Pag_id`, `Pag_tipo`, `Pag_num_cartao`, `Pag_data`, `Pag_total_compra`, `Pag_nome_cliente`) VALUES
(1, 'visa', 124423412, '2020-12-16', 12.4, 'nagazaki'),
(2, 'maestro', 1929383, '2020-12-23', 45.6, 'inoue');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `Prod_id` int(30) NOT NULL,
  `Prod_nome` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prod_preco` double DEFAULT NULL,
  `Prod_descricao` text COLLATE utf8_unicode_ci NOT NULL,
  `Prod_fk_carr` int(11) DEFAULT NULL,
  `Prod_marca` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prod_fk_Stock` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`Prod_id`, `Prod_nome`, `Prod_preco`, `Prod_descricao`, `Prod_fk_carr`, `Prod_marca`, `Prod_fk_Stock`) VALUES
(14, 'sapato', 5, 'Muito consistente e durável', 3, 'nike', 2),
(15, 'Pó Dentário Natural', 7.95, 'Deixa os dentes muito branquinhos', 3, 'Georganics', 3),
(17, 'tenis', 12.5, 'bom tenis', 3, 'nike', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `stocks`
--

CREATE TABLE `stocks` (
  `Stock_id` int(30) NOT NULL,
  `Stock_quant_prod` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Extraindo dados da tabela `stocks`
--

INSERT INTO `stocks` (`Stock_id`, `Stock_quant_prod`) VALUES
(1, 24),
(2, 43),
(3, 21),
(4, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `utilizadores`
--

CREATE TABLE `utilizadores` (
  `Uti_id` int(30) NOT NULL,
  `Uti_nome` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_data_Nac` date DEFAULT NULL,
  `Uti_morada` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_sexo` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Uti_password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `utilizadores`
--

INSERT INTO `utilizadores` (`Uti_id`, `Uti_nome`, `Uti_data_Nac`, `Uti_morada`, `Uti_sexo`, `Uti_email`, `Uti_password`) VALUES
(1, 'Nagasaki', '1990-11-12', 'praceta henrique pousão', 'M', 'nagasaki12@gmail.com', 'naga'),
(2, 'Shikamaru', '1994-08-20', 'praceta mario leiria', 'M', 'shikamaru20@gmail.com', 'shika20'),
(3, 'Inoue', '1996-01-07', 'rua da bolivia', 'F', 'inoue7@gmail.com', 'inoue7');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedores`
--

CREATE TABLE `vendedores` (
  `vend_id` int(30) NOT NULL,
  `vend_cargo` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vend_fk_uti` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `vendedores`
--

INSERT INTO `vendedores` (`vend_id`, `vend_cargo`, `vend_fk_uti`) VALUES
(2, 'Recepcionista ', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor_encomendas`
--

CREATE TABLE `vendedor_encomendas` (
  `Vend_enc_id` int(11) NOT NULL,
  `Vend_enc_fk_enc` int(11) NOT NULL,
  `Vend_enc_fk_vend` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor_Produtos`
--

CREATE TABLE `vendedor_Produtos` (
  `VendProd_fk_prod` int(11) NOT NULL,
  `VendProd_fk_vend` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carrinhos`
--
ALTER TABLE `carrinhos`
  ADD PRIMARY KEY (`Carr_id`);

--
-- Indexes for table `carrinho_produtos`
--
ALTER TABLE `carrinho_produtos`
  ADD PRIMARY KEY (`carrprod_fk_carr`,`carrprod_fk_prod`),
  ADD KEY `carrprod_fk_prod` (`carrprod_fk_prod`);

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`Cat_id`);

--
-- Indexes for table `categoria_produtos`
--
ALTER TABLE `categoria_produtos`
  ADD PRIMARY KEY (`Cat_Prod_id`),
  ADD KEY `fk1` (`catprod_fk_cat`),
  ADD KEY `fk2` (`catprod_fk_prod`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`Cli_id`),
  ADD KEY `clienteFK` (`cli_fk_uti`),
  ADD KEY `carrFK` (`cli_fk_carr`);

--
-- Indexes for table `encomendas`
--
ALTER TABLE `encomendas`
  ADD PRIMARY KEY (`Enc_id`),
  ADD KEY `EcFk` (`Enc_cli_id`),
  ADD KEY `Enc_fk_carr` (`Enc_fk_carr`);

--
-- Indexes for table `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD PRIMARY KEY (`Pag_id`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`Prod_id`),
  ADD KEY `StockFK` (`Prod_fk_Stock`),
  ADD KEY `Prod_fk_carr` (`Prod_fk_carr`);

--
-- Indexes for table `stocks`
--
ALTER TABLE `stocks`
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
  ADD PRIMARY KEY (`vend_id`),
  ADD KEY `utiFK` (`vend_fk_uti`);

--
-- Indexes for table `vendedor_encomendas`
--
ALTER TABLE `vendedor_encomendas`
  ADD PRIMARY KEY (`Vend_enc_id`),
  ADD KEY `encFK` (`Vend_enc_fk_enc`),
  ADD KEY `venFK` (`Vend_enc_fk_vend`);

--
-- Indexes for table `vendedor_Produtos`
--
ALTER TABLE `vendedor_Produtos`
  ADD KEY `VendProd_fk_prod` (`VendProd_fk_prod`),
  ADD KEY `VendProd_fk_vend` (`VendProd_fk_vend`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carrinhos`
--
ALTER TABLE `carrinhos`
  MODIFY `Carr_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `Cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `categoria_produtos`
--
ALTER TABLE `categoria_produtos`
  MODIFY `Cat_Prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `Cli_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `encomendas`
--
ALTER TABLE `encomendas`
  MODIFY `Enc_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `pagamentos`
--
ALTER TABLE `pagamentos`
  MODIFY `Pag_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `Prod_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `stocks`
--
ALTER TABLE `stocks`
  MODIFY `Stock_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `utilizadores`
--
ALTER TABLE `utilizadores`
  MODIFY `Uti_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `vend_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vendedor_encomendas`
--
ALTER TABLE `vendedor_encomendas`
  MODIFY `Vend_enc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `carrinho_produtos`
--
ALTER TABLE `carrinho_produtos`
  ADD CONSTRAINT `carrinho_produtos_ibfk_1` FOREIGN KEY (`carrprod_fk_carr`) REFERENCES `carrinhos` (`carr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `carrinho_produtos_ibfk_2` FOREIGN KEY (`carrprod_fk_prod`) REFERENCES `produtos` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `categoria_produtos`
--
ALTER TABLE `categoria_produtos`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`catprod_fk_cat`) REFERENCES `categorias` (`cat_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`catprod_fk_prod`) REFERENCES `produtos` (`prod_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `carrFK` FOREIGN KEY (`cli_fk_carr`) REFERENCES `carrinhos` (`carr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `clienteFK` FOREIGN KEY (`cli_fk_uti`) REFERENCES `utilizadores` (`uti_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `encomendas`
--
ALTER TABLE `encomendas`
  ADD CONSTRAINT `EcFk` FOREIGN KEY (`Enc_cli_id`) REFERENCES `clientes` (`cli_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `encomendas_ibfk_2` FOREIGN KEY (`Enc_fk_carr`) REFERENCES `carrinhos` (`carr_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `StockFK` FOREIGN KEY (`Prod_fk_Stock`) REFERENCES `stocks` (`stock_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`Prod_fk_carr`) REFERENCES `carrinhos` (`carr_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `vendedores`
--
ALTER TABLE `vendedores`
  ADD CONSTRAINT `utiFK` FOREIGN KEY (`vend_fk_uti`) REFERENCES `utilizadores` (`uti_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `vendedor_encomendas`
--
ALTER TABLE `vendedor_encomendas`
  ADD CONSTRAINT `encFK` FOREIGN KEY (`Vend_enc_fk_enc`) REFERENCES `encomendas` (`enc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `venFK` FOREIGN KEY (`Vend_enc_fk_vend`) REFERENCES `vendedores` (`vend_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `vendedor_Produtos`
--
ALTER TABLE `vendedor_Produtos`
  ADD CONSTRAINT `vendedor_Produtos_ibfk_1` FOREIGN KEY (`VendProd_fk_prod`) REFERENCES `produtos` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vendedor_Produtos_ibfk_2` FOREIGN KEY (`VendProd_fk_vend`) REFERENCES `vendedores` (`vend_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
