-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 31-Jan-2021 às 10:27
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
  `Carr_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `carrinhos`
--

INSERT INTO `carrinhos` (`Carr_id`) VALUES
(3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `carrinho_produtos`
--

CREATE TABLE `carrinho_produtos` (
  `carrprod_fk_carr` int(11) NOT NULL,
  `carrprod_fk_prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(3, 'Limpeza'),
(4, 'Cosmétca'),
(5, 'Acessórios'),
(6, 'Calçado');

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
(23, 5, 21),
(24, 6, 19),
(25, 4, 22),
(26, 3, 24),
(27, 3, 23),
(28, 1, 20);

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
  `Enc_estado` int(40) NOT NULL,
  `Enc_preco_Porte` double DEFAULT NULL,
  `Enc_preco_Total` double DEFAULT NULL,
  `Enc_cli_id` int(40) NOT NULL,
  `Enc_vend_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `encomenda_produtos`
--

CREATE TABLE `encomenda_produtos` (
  `encpro_fk_enc` int(200) NOT NULL,
  `encpro_fk_prod` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado_encomendas`
--

CREATE TABLE `estado_encomendas` (
  `Estenc_id` int(40) NOT NULL,
  `Estenc_estado` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `estado_encomendas`
--

INSERT INTO `estado_encomendas` (`Estenc_id`, `Estenc_estado`) VALUES
(0, 'Nova'),
(1, 'Aguarde'),
(2, 'Enviada'),
(3, 'Entregue');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `Prod_id` int(30) NOT NULL,
  `Prod_nome` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prod_preco` double DEFAULT NULL,
  `Prod_descricao` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Prod_fk_carr` int(11) DEFAULT NULL,
  `Prod_marca` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prod_fk_Stock` int(30) NOT NULL,
  `prod_fk_vend` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`Prod_id`, `Prod_nome`, `Prod_preco`, `Prod_descricao`, `Prod_fk_carr`, `Prod_marca`, `Prod_fk_Stock`, `prod_fk_vend`) VALUES
(19, 'Sandália Ecológica - Brown Wave', 12.5, 'Composição:\r\n\r\nParte superior: Pinatex Castanho | Entressola: Borracha Natural, cortiça e Juta | Sola: Borracha Natural feita de lixo plástico retirado do oceano.\r\n\r\nTamanhos 35-41 (mulher) | 41-45 (Homem)\r\n\r\nA ZOURI utiliza lixo plástico na produção de calçado eco-vegan.\r\n\r\nEm cada par de ZOURI são reutilizados cerca de 6 garrafas de plástico.', 3, 'Zouri Shoes', 1, 2),
(20, 'Pó Dentário Natural Georganics - Carvão Ativado', 7.5, 'Natural e livre de ingredientes tóxicos, o pó irá absorver e remover a placa bacteriana e manchas dos dentes. Esta fórmula mistura carvão ativado e bicarbonato de sódio farmacêutico fino, ingredientes de base alimentar sendo completamente seguros se ingeridos acidentalmente. Fórmula totalmente segura, de rápidos resultados e é feita sem ingredientes químicos como peróxidos, flúor ou aromas sintéticos.\r\n\r\n \r\nEmbalagem Desperdício Zero: caixa feita de papel craft compostável com impressão com tinta vegetal, e frasco de vidro com tampa de alumínio. PETA Cruelty-Free e Certifcado Vegano', 3, 'Georganics', 2, 2),
(21, 'Bolsa de cortiça', 30, 'Bolsa de Cortiça estruturada com alça de cortiça, bolso interno para telefone e chaves, bolso externo com ziper.\r\n\r\nDetalhes com tachas.\r\n\r\nFeita com cortiça de alta qualidade, macia, flexível e de longa duração.\r\n\r\nTamanho: 27cmX9cm\r\n\r\nFeito em Portugal\r\n\r\nTrabalho completamente artesanal', 3, 'MB CORK', 3, 2),
(22, 'Palete de Sombras - Vegan', 19.9, 'Palete de sombras com 18 tonalidades.\r\n\r\nSombras de alta pigmentação à prova de água.\r\n\r\nO objetivo da Bali é desenvolver os cosméticos com a melhor performance sem nunca esquecer os valores pelos quais nos regemos, a compaixão, sustentabilidade e a luta for um mundo \"cruelty free\".\r\n\r\nO projeto é desenvolvido com uma enorme paixão e tem o seguinte lema:  \"Acreditamos que a verdadeira beleza vem com bondade, de dentro para fora.\"\r\n\r\nCom uma crescente gama de cosméticos veganos e livres de crueldade, oferecem a melhor qualidade aliada aos mais elevados padrões morais.\r\n\r\nTodas as suas criações resultam de um casamento feliz entre cosméticos de alta performance e a luta por um mundo sem crueldade.\r\nTodos os seus produtos têm alta pigmentação e são de longa duração, de modo não só a criar uma melhor experiencia para os nosso consumidores como reduzir o desperdício de embalagens.', 3, ' Bali', 5, 2),
(23, 'Óleo Essencial de Eucalipto', 9.95, 'O Óleo Essencial de Eucalipto pode ser usado de diversas formas:\r\n\r\nAromaterapia – 6 a 7 gotas no difusor tem um efeito descongestionante e balsâmico. Também funciona como estimulante mental, que melhora significativamente os níveis de concentração e de produtividade.\r\n\r\nCorpo – Adequado para tratamento de pele, principalmente a oleosa: Também eficaz no caso de queimaduras, feridas, bolhas, picadas de insectos e infecções cutâneas, em geral. O eucalipto é talvez o mais indicado para o tratamento de constipações e gripes, mas é ainda eficaz contra músculos e articulações doridas. Desintoxicante natural, este óleo revigora o sistema imunitário, circulatório e respiratório.\r\n\r\nÓleos extraídos por destilação a vapor.\r\n\r\n10ml', 3, 'Alegro', 6, 2),
(24, 'Abrilhantador Máquina Louça | 500ml', 5, 'Abrilhantador Ecológico para Máquina Loiça | Bioermi by Allegro Natura\r\nPara um brilho natural! Remove manchas e dá um efeito resplandecente, previne aparecimento de resíduos de calcário na loiça. Produzido com tensoativos de origem vegetal.\r\n\r\nProduto biodegradável.\r\nSem ingredientes de origem animal\r\nNão testado em animais.\r\nSem SLS, EDTA, fosfatos, branqueadores, parabenos, fósforo, corantes.\r\n\r\n\r\n\r\nCOMPOSIÇÃO: Contém inf. 5% de agentes tensioactivos não iónicos (reg. 648/2004/CE)\r\n\r\nINCI: aqua, citric acid, Caprylyl/Decyl glucoside, Sodium polyaspartate', 3, 'Alegro', 7, 2);

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
(1, 22),
(2, 0),
(3, 56),
(5, 134),
(6, 0),
(7, 321);

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
  ADD KEY `Enc_estado` (`Enc_estado`),
  ADD KEY `Enc_vend_id` (`Enc_vend_id`);

--
-- Indexes for table `encomenda_produtos`
--
ALTER TABLE `encomenda_produtos`
  ADD PRIMARY KEY (`encpro_fk_enc`,`encpro_fk_prod`),
  ADD KEY `encpro_fk_pro` (`encpro_fk_prod`);

--
-- Indexes for table `estado_encomendas`
--
ALTER TABLE `estado_encomendas`
  ADD PRIMARY KEY (`Estenc_id`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`Prod_id`),
  ADD KEY `StockFK` (`Prod_fk_Stock`),
  ADD KEY `Prod_fk_carr` (`Prod_fk_carr`),
  ADD KEY `prod_fk_vend` (`prod_fk_vend`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carrinhos`
--
ALTER TABLE `carrinhos`
  MODIFY `Carr_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `Cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `categoria_produtos`
--
ALTER TABLE `categoria_produtos`
  MODIFY `Cat_Prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `Cli_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `encomendas`
--
ALTER TABLE `encomendas`
  MODIFY `Enc_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `Prod_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `stocks`
--
ALTER TABLE `stocks`
  MODIFY `Stock_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
  ADD CONSTRAINT `encomendas_ibfk_1` FOREIGN KEY (`Enc_estado`) REFERENCES `estado_encomendas` (`estenc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `encomendas_ibfk_2` FOREIGN KEY (`Enc_vend_id`) REFERENCES `vendedores` (`vend_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `encomenda_produtos`
--
ALTER TABLE `encomenda_produtos`
  ADD CONSTRAINT `encomenda_produtos_ibfk_1` FOREIGN KEY (`encpro_fk_enc`) REFERENCES `encomendas` (`enc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `encomenda_produtos_ibfk_2` FOREIGN KEY (`encpro_fk_prod`) REFERENCES `produtos` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `StockFK` FOREIGN KEY (`Prod_fk_Stock`) REFERENCES `stocks` (`stock_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`Prod_fk_carr`) REFERENCES `carrinhos` (`carr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`prod_fk_vend`) REFERENCES `vendedores` (`vend_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `vendedores`
--
ALTER TABLE `vendedores`
  ADD CONSTRAINT `utiFK` FOREIGN KEY (`vend_fk_uti`) REFERENCES `utilizadores` (`uti_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
