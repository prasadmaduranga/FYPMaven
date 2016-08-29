-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2016 at 02:31 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `fyp`
--

-- --------------------------------------------------------

--
-- Table structure for table `chart`
--

CREATE TABLE IF NOT EXISTS `chart` (
  `chartId` int(11) NOT NULL AUTO_INCREMENT,
  `chartName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`chartId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `chart`
--

INSERT INTO `chart` (`chartId`, `chartName`) VALUES
(1, 'Bar chart'),
(2, 'Pie chart'),
(3, 'Tree Map'),
(4, 'test'),
(5, 'Line chart'),
(7, 'Bivariate area chart'),
(8, 'Stacked area chart'),
(11, 'Stacked Bar chart'),
(12, 'Nomalized stacked bar chart'),
(13, 'Grouped bar chart'),
(14, 'Scatterplot'),
(15, 'Muiltiple Bar chart'),
(16, 'Pin point location heat map'),
(17, 'Mark Area heat map'),
(18, 'Bubble chart'),
(19, 'Calender view chart'),
(20, 'Cluster dendgram'),
(22, 'Parallel cordinates'),
(23, 'Sankey diagram'),
(24, 'Boxplot'),
(25, 'Pin point location  map'),
(26, 'Mark Area  map');

-- --------------------------------------------------------

--
-- Table structure for table `chartdimension`
--

CREATE TABLE IF NOT EXISTS `chartdimension` (
  `dimentionId` int(11) NOT NULL AUTO_INCREMENT,
  `chartId` int(11) DEFAULT NULL,
  `dimensionIndex` int(11) DEFAULT NULL,
  `contineous` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`dimentionId`),
  KEY `chartId` (`chartId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=62 ;

--
-- Dumping data for table `chartdimension`
--

INSERT INTO `chartdimension` (`dimentionId`, `chartId`, `dimensionIndex`, `contineous`) VALUES
(1, 1, 1, 0),
(2, 1, 2, 1),
(3, 4, 1, 1),
(4, 4, 2, 1),
(5, 5, 1, 1),
(6, 5, 2, 1),
(7, 5, 3, 0),
(8, 2, 1, 0),
(9, 2, 2, 1),
(10, 3, 1, 0),
(11, 3, 2, 0),
(12, 3, 3, 1),
(13, 7, 1, 1),
(14, 7, 2, 1),
(15, 7, 3, 0),
(16, 8, 1, 1),
(17, 8, 2, 1),
(18, 8, 3, 0),
(19, 11, 1, 0),
(20, 11, 2, 1),
(21, 11, 3, 0),
(22, 12, 1, 0),
(23, 12, 2, 1),
(24, 12, 3, 0),
(25, 13, 1, 0),
(26, 13, 2, 1),
(27, 13, 3, 0),
(28, 14, 1, 1),
(29, 14, 2, 1),
(30, 14, 3, 0),
(31, 16, 1, 0),
(32, 16, 2, 1),
(33, 17, 1, 0),
(34, 17, 2, 1),
(35, 18, 1, 1),
(36, 18, 2, 0),
(37, 18, 3, 1),
(38, 18, 4, 1),
(39, 19, 1, 1),
(40, 19, 2, 1),
(41, 20, 1, 0),
(42, 20, 2, 0),
(43, 20, 3, 1),
(44, 20, 3, 0),
(45, 22, 1, 1),
(46, 22, 2, 1),
(47, 22, 3, 1),
(48, 22, 4, 1),
(49, 22, 5, 1),
(50, 22, 6, 1),
(51, 22, 1, 0),
(52, 22, 2, 0),
(53, 22, 3, 0),
(54, 22, 4, 0),
(55, 22, 5, 0),
(56, 22, 6, 0),
(57, 23, 1, 0),
(58, 23, 2, 0),
(59, 23, 3, 1),
(60, 24, 1, 0),
(61, 24, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `chartdimensioncardinality`
--

CREATE TABLE IF NOT EXISTS `chartdimensioncardinality` (
  `dimensionId` int(11) NOT NULL DEFAULT '0',
  `cardinality` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`dimensionId`,`cardinality`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chartdimensioncardinality`
--

INSERT INTO `chartdimensioncardinality` (`dimensionId`, `cardinality`) VALUES
(1, 'Low'),
(1, 'Moderate'),
(2, 'Any'),
(3, 'Any'),
(4, 'Any'),
(5, 'Any'),
(6, 'Any'),
(7, 'Low'),
(8, 'Low'),
(9, 'Any'),
(10, 'High'),
(10, 'Low'),
(10, 'Moderate'),
(11, 'Low'),
(11, 'Moderate'),
(12, 'Any'),
(13, 'Any'),
(14, 'Any'),
(15, 'Low'),
(16, 'Any'),
(17, 'Any'),
(18, 'Low'),
(19, 'Low'),
(19, 'Moderate'),
(20, 'Any'),
(21, 'Low'),
(22, 'Low'),
(22, 'Moderate'),
(23, 'Any'),
(24, 'Low'),
(25, 'Low'),
(26, 'Any'),
(27, 'Low'),
(28, 'Any'),
(29, 'Any'),
(30, 'Low'),
(31, 'High'),
(31, 'Low'),
(31, 'Moderate'),
(32, 'Any'),
(33, 'High'),
(33, 'Low'),
(33, 'Moderate'),
(34, 'Any'),
(35, 'Any'),
(36, 'Low'),
(37, 'Any'),
(38, 'Any'),
(39, 'Any'),
(40, 'Any'),
(41, 'Low'),
(41, 'Moderate'),
(42, 'High'),
(42, 'Moderate'),
(43, 'Any'),
(44, 'High'),
(44, 'Low'),
(44, 'Moderate'),
(45, 'Any'),
(46, 'Any'),
(47, 'Any'),
(48, 'Any'),
(49, 'Any'),
(50, 'Any'),
(51, 'High'),
(51, 'Low'),
(51, 'Moderate'),
(52, 'High'),
(52, 'Low'),
(52, 'Moderate'),
(53, 'High'),
(53, 'Low'),
(53, 'Moderate'),
(54, 'High'),
(54, 'Low'),
(54, 'Moderate'),
(55, 'High'),
(55, 'Low'),
(55, 'Moderate'),
(56, 'High'),
(56, 'Low'),
(56, 'Moderate'),
(57, 'Low'),
(57, 'Moderate'),
(58, 'Low'),
(58, 'Moderate'),
(59, 'Any'),
(60, 'Low'),
(60, 'Moderate'),
(61, 'Any');

-- --------------------------------------------------------

--
-- Table structure for table `column`
--

CREATE TABLE IF NOT EXISTS `column` (
  `columnId` int(11) NOT NULL AUTO_INCREMENT,
  `tableId` int(11) DEFAULT NULL,
  `header` varchar(100) DEFAULT NULL,
  `cardinality` int(11) DEFAULT NULL,
  `dataType` varchar(20) DEFAULT NULL,
  `contextDesc` varchar(500) DEFAULT NULL,
  `isContinuous` tinyint(4) NOT NULL,
  PRIMARY KEY (`columnId`),
  KEY `tableId` (`tableId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `column`
--

INSERT INTO `column` (`columnId`, `tableId`, `header`, `cardinality`, `dataType`, `contextDesc`, `isContinuous`) VALUES
(1, 4, 'city name', 10, 'String', 'Location', 0),
(2, 4, 'temperature', -1, 'float', 'Numeric', 1),
(3, 1, 'Continenet', 4, 'String', 'Location', 0),
(4, 1, 'Country', 15, 'String', 'Location', 0),
(5, 1, 'Export percentage', 15, 'String', 'Percentage', 1),
(6, 7, 'Over', 300, 'float', 'Numeric', 1),
(8, 7, 'Runs', 280, 'int', 'Numeric', 1),
(9, 7, 'Team', 2, 'String', 'Nominal', 0),
(10, 8, 'Continent', 5, 'String', 'Location', 0),
(11, 8, 'Country', 25, 'String', 'Location', 0),
(12, 8, 'Perentage', -1, 'Float', 'Percentage', 1),
(13, 9, 'Province', 9, 'String', 'Location', 0),
(14, 9, 'District', 24, 'String', 'Location', 0),
(15, 9, 'Patient count', 0, 'int', 'Numeric', 1);

-- --------------------------------------------------------

--
-- Table structure for table `dimensioncontext`
--

CREATE TABLE IF NOT EXISTS `dimensioncontext` (
  `dimensionId` int(11) NOT NULL DEFAULT '0',
  `description` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`dimensionId`,`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dimensioncontext`
--

INSERT INTO `dimensioncontext` (`dimensionId`, `description`) VALUES
(1, 'Location'),
(1, 'Nominal'),
(2, 'Numeric'),
(3, 'Numeric'),
(4, 'Numeric'),
(5, 'Numeric'),
(5, 'Time series'),
(6, 'Numeric'),
(7, 'Location'),
(7, 'Nominal'),
(7, 'Ordinal'),
(8, 'Location'),
(8, 'Nominal'),
(8, 'Ordinal'),
(9, 'Percentage'),
(10, 'Location'),
(10, 'Nominal'),
(10, 'Ordinal'),
(11, 'Location'),
(11, 'Nominal'),
(11, 'Ordinal'),
(12, 'Percentage'),
(13, 'Numeric'),
(13, 'Time series'),
(14, 'Numeric'),
(15, 'Location'),
(15, 'Nominal'),
(15, 'Ordinal'),
(16, 'Numeric'),
(16, 'Time series'),
(17, 'Percentage'),
(18, 'Location'),
(18, 'Nominal'),
(18, 'Ordinal'),
(19, 'Location'),
(19, 'Nominal'),
(19, 'Ordinal'),
(20, 'Numeric'),
(21, 'Location'),
(21, 'Nominal'),
(21, 'Ordinal'),
(22, 'Location'),
(22, 'Nominal'),
(22, 'Ordinal'),
(23, 'Percentage'),
(24, 'Location'),
(24, 'Nominal'),
(24, 'Ordinal'),
(25, 'Location'),
(25, 'Nominal'),
(25, 'Ordinal'),
(26, 'Numeric'),
(27, 'Location'),
(27, 'Nominal'),
(27, 'Ordinal'),
(28, 'Numeric'),
(28, 'Time series'),
(29, 'Numeric'),
(30, 'Location'),
(30, 'Nominal'),
(30, 'Ordinal'),
(31, 'Location'),
(32, 'Numeric'),
(33, 'Location'),
(34, 'Numeric'),
(35, 'Numeric'),
(36, 'Location'),
(36, 'Nominal'),
(36, 'Ordinal'),
(37, 'Numeric'),
(37, 'Time series'),
(38, 'Numeric'),
(39, 'Time series'),
(40, 'Numeric'),
(41, 'Location'),
(41, 'Nominal'),
(41, 'Ordinal'),
(42, 'Location'),
(42, 'Nominal'),
(42, 'Ordinal'),
(43, 'Numeric'),
(44, 'Location'),
(44, 'Nominal'),
(44, 'Ordinal'),
(45, 'Numeric'),
(45, 'Percentage'),
(45, 'Time series'),
(46, 'Numeric'),
(46, 'Percentage'),
(46, 'Time series'),
(47, 'Numeric'),
(47, 'Percentage'),
(47, 'Time series'),
(48, 'Numeric'),
(48, 'Percentage'),
(48, 'Time series'),
(49, 'Numeric'),
(49, 'Percentage'),
(49, 'Time series'),
(50, 'Numeric'),
(50, 'Percentage'),
(50, 'Time series'),
(51, 'Location'),
(51, 'Nominal'),
(51, 'Ordinal'),
(52, 'Location'),
(52, 'Nominal'),
(52, 'Ordinal'),
(53, 'Location'),
(53, 'Nominal'),
(53, 'Ordinal'),
(54, 'Location'),
(54, 'Nominal'),
(54, 'Ordinal'),
(55, 'Location'),
(55, 'Nominal'),
(55, 'Ordinal'),
(56, 'Location'),
(56, 'Nominal'),
(56, 'Ordinal'),
(57, 'Location'),
(57, 'Nominal'),
(57, 'Ordinal'),
(58, 'Location'),
(58, 'Nominal'),
(58, 'Ordinal'),
(59, 'Percentage'),
(60, 'Location'),
(60, 'Nominal'),
(60, 'Ordinal'),
(61, 'Numeric');

-- --------------------------------------------------------

--
-- Table structure for table `dimensioncount`
--

CREATE TABLE IF NOT EXISTS `dimensioncount` (
  `countId` int(11) NOT NULL AUTO_INCREMENT,
  `chartId` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`countId`),
  KEY `chartId` (`chartId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `dimensioncount`
--

INSERT INTO `dimensioncount` (`countId`, `chartId`, `count`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 2),
(4, 3, 2),
(5, 3, 3),
(6, 4, 2),
(7, 5, 2),
(8, 5, 3),
(9, 2, 2),
(10, 3, 2),
(11, 3, 3),
(12, 7, 3),
(13, 8, 3),
(14, 11, 3),
(15, 12, 3),
(16, 13, 3),
(17, 14, 2),
(18, 14, 3),
(19, 16, 2),
(20, 17, 2),
(21, 18, 2),
(22, 18, 4),
(23, 19, 2),
(24, 20, 2),
(25, 20, 3),
(26, 22, 2),
(27, 22, 3),
(28, 22, 4),
(29, 22, 5),
(30, 22, 6),
(31, 23, 3),
(32, 24, 2);

-- --------------------------------------------------------

--
-- Table structure for table `intension`
--

CREATE TABLE IF NOT EXISTS `intension` (
  `intensionId` int(11) NOT NULL AUTO_INCREMENT,
  `chartId` int(11) DEFAULT NULL,
  `intensionDesc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`intensionId`),
  KEY `chartId` (`chartId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=37 ;

--
-- Dumping data for table `intension`
--

INSERT INTO `intension` (`intensionId`, `chartId`, `intensionDesc`) VALUES
(1, 1, 'Comparison'),
(2, 2, 'Composition'),
(3, 3, 'Composition'),
(4, 4, 'Comparison'),
(5, 5, 'Comparison'),
(6, 5, 'Distribution'),
(7, 2, 'Composition'),
(8, 3, 'Composition'),
(9, 7, 'Comparison'),
(10, 8, 'Composition'),
(11, 8, 'Comparison'),
(12, 8, 'Distribution'),
(13, 11, 'Comparison'),
(14, 11, 'Distribution'),
(15, 11, 'Composition'),
(16, 12, 'Distribution'),
(17, 12, 'Comparison'),
(18, 12, 'Composition'),
(19, 13, 'Comparison'),
(20, 13, 'Distribution'),
(21, 13, 'Composition'),
(22, 14, 'Distribution'),
(23, 16, 'Distribution'),
(24, 17, 'Distribution'),
(25, 18, 'Distribution'),
(26, 18, 'Relationship'),
(27, 18, 'Comparison'),
(28, 19, 'Distribution'),
(29, 20, 'Distribution'),
(30, 20, 'Composition'),
(31, 22, 'Comparison'),
(32, 23, 'Composittion'),
(33, 23, 'Relationship'),
(34, 23, 'Comparison'),
(35, 24, 'Distribution'),
(36, 24, 'Comparison');

-- --------------------------------------------------------

--
-- Table structure for table `partialordering`
--

CREATE TABLE IF NOT EXISTS `partialordering` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `tableId` int(11) DEFAULT NULL,
  `columnId` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `childId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `tableId` (`tableId`),
  KEY `columnId` (`columnId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `recommendations`
--

CREATE TABLE IF NOT EXISTS `recommendations` (
  `chartId` int(11) NOT NULL DEFAULT '0',
  `tableId` int(11) NOT NULL DEFAULT '0',
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`chartId`,`tableId`),
  KEY `tableId` (`tableId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tabledimension`
--

CREATE TABLE IF NOT EXISTS `tabledimension` (
  `dimensionId` int(11) NOT NULL AUTO_INCREMENT,
  `tableId` int(11) DEFAULT NULL,
  `continneous` tinyint(4) DEFAULT NULL,
  `dimensionIndex` int(11) DEFAULT NULL,
  `cardinality` varchar(30) DEFAULT NULL,
  `context` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dimensionId`),
  KEY `tableId` (`tableId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `tabledimension`
--

INSERT INTO `tabledimension` (`dimensionId`, `tableId`, `continneous`, `dimensionIndex`, `cardinality`, `context`) VALUES
(1, 4, 0, 2, 'Moderate', 'Location'),
(2, 4, 1, 1, 'Any', 'Numeric'),
(3, 6, 1, 1, 'Any', 'Numeric'),
(4, 6, 1, 2, 'Any', 'Numeric'),
(5, 7, 1, 1, 'Any', 'Numeric'),
(6, 7, 1, 2, 'Any', 'Numeric'),
(7, 7, 0, 3, 'Low', 'Nominal'),
(8, 8, 0, 1, 'Low', 'Location'),
(9, 8, 0, 3, 'Moderate', 'Location'),
(10, 8, 1, 2, 'Any', 'Percentage'),
(11, 9, 0, 1, 'Moderate', 'Location'),
(12, 9, 0, 2, 'Moderate', 'Location'),
(13, 9, 1, 3, 'Any', 'Numeric');

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE IF NOT EXISTS `tables` (
  `tableId` int(11) NOT NULL AUTO_INCREMENT,
  `numberOfRows` int(11) DEFAULT NULL,
  `tableName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tableId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `tables`
--

INSERT INTO `tables` (`tableId`, `numberOfRows`, `tableName`) VALUES
(1, 15, NULL),
(2, 25, NULL),
(3, 2, NULL),
(4, 5, NULL),
(5, 10, NULL),
(6, 20, NULL),
(7, 300, 'Total Runs'),
(8, 20, 'Sri lankan exports'),
(9, 24, 'Dengue patient count');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chartdimension`
--
ALTER TABLE `chartdimension`
  ADD CONSTRAINT `chartdimension_ibfk_1` FOREIGN KEY (`chartId`) REFERENCES `chart` (`chartId`);

--
-- Constraints for table `chartdimensioncardinality`
--
ALTER TABLE `chartdimensioncardinality`
  ADD CONSTRAINT `chartdimensioncardinality_ibfk_1` FOREIGN KEY (`dimensionId`) REFERENCES `chartdimension` (`dimentionId`);

--
-- Constraints for table `column`
--
ALTER TABLE `column`
  ADD CONSTRAINT `column_ibfk_1` FOREIGN KEY (`tableId`) REFERENCES `tables` (`tableId`);

--
-- Constraints for table `dimensioncontext`
--
ALTER TABLE `dimensioncontext`
  ADD CONSTRAINT `dimensioncontext_ibfk_1` FOREIGN KEY (`dimensionId`) REFERENCES `chartdimension` (`dimentionId`);

--
-- Constraints for table `dimensioncount`
--
ALTER TABLE `dimensioncount`
  ADD CONSTRAINT `dimensioncount_ibfk_1` FOREIGN KEY (`chartId`) REFERENCES `chart` (`chartId`);

--
-- Constraints for table `intension`
--
ALTER TABLE `intension`
  ADD CONSTRAINT `intension_ibfk_1` FOREIGN KEY (`chartId`) REFERENCES `chart` (`chartId`);

--
-- Constraints for table `partialordering`
--
ALTER TABLE `partialordering`
  ADD CONSTRAINT `partialordering_ibfk_1` FOREIGN KEY (`tableId`) REFERENCES `tables` (`tableId`),
  ADD CONSTRAINT `partialordering_ibfk_2` FOREIGN KEY (`columnId`) REFERENCES `column` (`columnId`);

--
-- Constraints for table `recommendations`
--
ALTER TABLE `recommendations`
  ADD CONSTRAINT `recommendations_ibfk_1` FOREIGN KEY (`chartId`) REFERENCES `chart` (`chartId`),
  ADD CONSTRAINT `recommendations_ibfk_2` FOREIGN KEY (`tableId`) REFERENCES `tables` (`tableId`);

--
-- Constraints for table `tabledimension`
--
ALTER TABLE `tabledimension`
  ADD CONSTRAINT `tabledimension_ibfk_1` FOREIGN KEY (`tableId`) REFERENCES `tables` (`tableId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
