-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.9


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema dcfinancasbd
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ dcfinancasbd;
USE dcfinancasbd;

--
-- Table structure for table `dcfinancasbd`.`cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL DEFAULT '',
  `sobrenome` varchar(100) NOT NULL DEFAULT '',
  `data_nascimento` date NOT NULL,
  `cpf` int(11) DEFAULT NULL,
  `endereco` varchar(500) NOT NULL DEFAULT '',
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT 'nenhum',
  `celular` varchar(14) DEFAULT 'nenhum',
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idcliente`,`nome`,`sobrenome`,`data_nascimento`,`cpf`,`endereco`,`email`,`telefone`,`celular`) VALUES 
 (4,'Caio','Lima','1993-04-05',11111111,'Av. Ferreira Bandeira nº 179','ticaiolima@gmail.com','(75)3241-1891','(75)9177-5630'),
 (7,'David','Pinho','2011-04-06',11111111,'Av. Ferreira Bandeira ','pinho08@yahoo.com.br','(75)3241-1161','(75)8175-2492'),
 (8,'Carol','Texeira','1993-06-17',11111111,'São Francisco - Ba','carolmsn@hotmail.com','(71)8111-1111','(11)1111-1111');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`encomenda_produto`
--

DROP TABLE IF EXISTS `encomenda_produto`;
CREATE TABLE `encomenda_produto` (
  `idvenda` int(11) NOT NULL,
  `idproduto` int(11) NOT NULL,
  PRIMARY KEY (`idvenda`,`idproduto`),
  KEY `fk_venda_has_produto_venda1` (`idvenda`),
  KEY `fk_venda_has_produto_produto1` (`idproduto`),
  CONSTRAINT `fk_venda_has_produto_produto1` FOREIGN KEY (`idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_has_produto_venda1` FOREIGN KEY (`idvenda`) REFERENCES `venda` (`idvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`encomenda_produto`
--

/*!40000 ALTER TABLE `encomenda_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `encomenda_produto` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE `fornecedor` (
  `idfornecedor` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  PRIMARY KEY (`idfornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`fornecedor`
--

/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`imagem`
--

DROP TABLE IF EXISTS `imagem`;
CREATE TABLE `imagem` (
  `idimagem` int(11) NOT NULL,
  `imagem` varchar(500) NOT NULL,
  `idproduto` int(11) NOT NULL,
  PRIMARY KEY (`idimagem`),
  KEY `fk_imagem_produto1` (`idproduto`),
  CONSTRAINT `fk_imagem_produto1` FOREIGN KEY (`idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`imagem`
--

/*!40000 ALTER TABLE `imagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagem` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(400) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL,
  `idfornecedor` int(11) NOT NULL,
  PRIMARY KEY (`idproduto`),
  KEY `fk_produto_fornecedor1` (`idfornecedor`),
  CONSTRAINT `fk_produto_fornecedor1` FOREIGN KEY (`idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`produto`
--

/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL,
  `hora` time NOT NULL,
  `data` date NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idtipo_servico` int(11) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_cliente1` (`idcliente`),
  KEY `fk_reserva_tipo_servico1` (`idtipo_servico`),
  CONSTRAINT `fk_reserva_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_tipo_servico1` FOREIGN KEY (`idtipo_servico`) REFERENCES `tipo_servico` (`idtipo_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`reserva`
--

/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`servico`
--

DROP TABLE IF EXISTS `servico`;
CREATE TABLE `servico` (
  `idvenda` int(11) NOT NULL,
  `idtipo_servico` int(11) NOT NULL,
  PRIMARY KEY (`idvenda`,`idtipo_servico`),
  KEY `fk_venda_has_tipo_servico_venda1` (`idvenda`),
  KEY `fk_venda_has_tipo_servico_tipo_servico1` (`idtipo_servico`),
  CONSTRAINT `fk_venda_has_tipo_servico_tipo_servico1` FOREIGN KEY (`idtipo_servico`) REFERENCES `tipo_servico` (`idtipo_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_has_tipo_servico_venda1` FOREIGN KEY (`idvenda`) REFERENCES `venda` (`idvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`servico`
--

/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE `telefone` (
  `idtelefone` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `idcliente` int(11) NOT NULL,
  PRIMARY KEY (`idtelefone`),
  KEY `fk_telefones_cliente` (`idcliente`),
  CONSTRAINT `fk_telefones_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`telefone`
--

/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`tipo_servico`
--

DROP TABLE IF EXISTS `tipo_servico`;
CREATE TABLE `tipo_servico` (
  `idtipo_servico` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(500) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`idtipo_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`tipo_servico`
--

/*!40000 ALTER TABLE `tipo_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_servico` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE `venda` (
  `data_venda` date NOT NULL,
  `valor_total` double NOT NULL,
  `data_pagamento` date NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idvenda` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idvenda`),
  KEY `fk_venda_cliente1` (`idcliente`),
  CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`venda`
--

/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
