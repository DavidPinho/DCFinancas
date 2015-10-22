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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idcliente`,`nome`,`sobrenome`,`data_nascimento`,`cpf`,`endereco`,`email`,`telefone`,`celular`) VALUES 
 (4,'Caio','Lima','1993-04-05',11111111,'Av. Ferreira Bandeira nº 179','ticaiolima@gmail.com','(75)3241-1891','(75)9177-5630'),
 (7,'David','Pinho','2011-04-06',11111111,'Av. Ferreira Bandeira ','pinho08@yahoo.com.br','(75)3241-1161','(75)8175-2492'),
 (8,'Carol','Texeira','1993-06-17',11111111,'São Francisco - Ba','carolmsn@hotmail.com','(71)8111-1111','(11)1111-1111'),
 (9,'Elijalma','Lima','1980-10-25',99999999,'Av. Ferreira Bandeira','liu@hotmail.com','(75)3241-1891','(  )    -    '),
 (10,'José Carlos','Lessa','1960-03-30',11111111,'Av. Paulino de Andrade n-2','asasasasa','(75)3241-1210','(  )    -    '),
 (11,'Leila','Paim','2011-12-24',11111111,'asasasasa','asasassa','(75)3241-5235','(  )    -    ');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`encomenda_produto`
--

DROP TABLE IF EXISTS `encomenda_produto`;
CREATE TABLE `encomenda_produto` (
  `idvenda` int(11) NOT NULL DEFAULT '0',
  `idproduto` int(11) NOT NULL,
  `qtd` float NOT NULL DEFAULT '0',
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
INSERT INTO `encomenda_produto` (`idvenda`,`idproduto`,`qtd`) VALUES 
 (15,2,2),
 (20,2,3),
 (22,2,1),
 (23,2,2),
 (23,3,10),
 (23,4,2);
/*!40000 ALTER TABLE `encomenda_produto` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE `fornecedor` (
  `idfornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) NOT NULL,
  `endereco` varchar(300) NOT NULL DEFAULT '',
  `email` varchar(100) NOT NULL DEFAULT '',
  `celular` varchar(45) NOT NULL DEFAULT '',
  `telefone` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idfornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`fornecedor`
--

/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`idfornecedor`,`nome`,`endereco`,`email`,`celular`,`telefone`) VALUES 
 (1,'Caio Cosmeticos','asasas','asasas','(75)3241-1891','(75)3241-1891'),
 (2,'Otica Oliveira','Centro','oticas@yahoo.com.br','(32)4156-3783','(75)3241-1892');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`historico_atendimento`
--

DROP TABLE IF EXISTS `historico_atendimento`;
CREATE TABLE `historico_atendimento` (
  `idhistorico_atendimento` int(11) NOT NULL AUTO_INCREMENT,
  `relatorio` text NOT NULL,
  `preco` float NOT NULL,
  `idreserva` int(11) NOT NULL,
  PRIMARY KEY (`idhistorico_atendimento`),
  KEY `fk_historico_atendimento_reserva1` (`idreserva`),
  CONSTRAINT `fk_historico_atendimento_reserva1` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dcfinancasbd`.`historico_atendimento`
--

/*!40000 ALTER TABLE `historico_atendimento` DISABLE KEYS */;
INSERT INTO `historico_atendimento` (`idhistorico_atendimento`,`relatorio`,`preco`,`idreserva`) VALUES 
 (1,'Meti o moicano!',10,7);
/*!40000 ALTER TABLE `historico_atendimento` ENABLE KEYS */;


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
  `quantidade` float NOT NULL DEFAULT '0',
  `valor` double NOT NULL,
  `idfornecedor` int(11) NOT NULL,
  PRIMARY KEY (`idproduto`),
  KEY `fk_produto_fornecedor1` (`idfornecedor`),
  CONSTRAINT `fk_produto_fornecedor1` FOREIGN KEY (`idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`produto`
--

/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`idproduto`,`nome`,`descricao`,`quantidade`,`valor`,`idfornecedor`) VALUES 
 (2,'Shampoo','asasas',4,12,1),
 (3,'Lente','Lente de contato azul.',40,230,2),
 (4,'Condicionador','moda praia\n	',80,12,1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `hora` time NOT NULL,
  `data` date NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idtipo_servico` int(11) NOT NULL,
  `atendido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_cliente1` (`idcliente`),
  KEY `fk_reserva_tipo_servico1` (`idtipo_servico`),
  CONSTRAINT `fk_reserva_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_tipo_servico1` FOREIGN KEY (`idtipo_servico`) REFERENCES `tipo_servico` (`idtipo_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`reserva`
--

/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`idreserva`,`hora`,`data`,`idcliente`,`idtipo_servico`,`atendido`) VALUES 
 (4,'10:00:00','2011-05-09',8,1,0),
 (5,'12:30:00','2011-05-04',7,1,0),
 (6,'20:00:00','2011-06-14',9,3,0),
 (7,'20:00:00','2011-07-05',8,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`tipo_servico`
--

/*!40000 ALTER TABLE `tipo_servico` DISABLE KEYS */;
INSERT INTO `tipo_servico` (`idtipo_servico`,`descricao`,`preco`) VALUES 
 (1,'Corte de Cabelo',10),
 (3,'Progressiva',25);
/*!40000 ALTER TABLE `tipo_servico` ENABLE KEYS */;


--
-- Table structure for table `dcfinancasbd`.`venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE `venda` (
  `data_venda` date NOT NULL DEFAULT '0000-00-00',
  `valor_total` double DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `idcliente` int(11) DEFAULT '0',
  `idvenda` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idvenda`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dcfinancasbd`.`venda`
--

/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` (`data_venda`,`valor_total`,`data_pagamento`,`idcliente`,`idvenda`) VALUES 
 ('2011-06-01',24,NULL,0,15),
 ('2011-06-22',36,'2011-07-05',4,20),
 ('2011-06-22',12,'2011-06-22',4,22),
 ('2011-07-05',24,'2011-07-05',7,23);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
