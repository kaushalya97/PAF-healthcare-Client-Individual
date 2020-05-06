-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 08:09 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `ano` int(11) NOT NULL,
  `aID` char(10) NOT NULL,
  `pName` varchar(40) NOT NULL,
  `dName` varchar(40) NOT NULL,
  `hName` varchar(40) NOT NULL,
  `roomNO` varchar(5) NOT NULL,
  `appNO` varchar(10) NOT NULL,
  `aDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`ano`, `aID`, `pName`, `dName`, `hName`, `roomNO`, `appNO`, `aDate`) VALUES
(1, 'A001', 'Mallika Samarasingha', 'Savin Mendis', 'Pannipitiya Nursing Home', 'R005', 'A102', '2020-04-18'),
(2, 'A002', 'Sarath Perera', 'Anura Kumara', 'Asiri Central', 'R002', 'A001', '2020-04-17'),
(3, 'A003', 'Dinura Weerasingha', 'Ramya Perera', 'Asiri Central', 'R001', 'A008', '2020-04-17'),
(6, 'A004', 'Ravindu Nimesh', 'Avinash Wijesooriya', 'Lanka Hospital', 'R003', 'A009', '2020-04-18'),
(8, 'A005', 'Ravindu Nimesh', 'Avinash Amarakoon', 'Lanka Hospital', 'R015', 'A010', '2020-04-21'),
(10, 'A006', 'Ramya Gamage', 'Vageesha Fernando', 'Lanka Hospital', 'R007', 'A013', '2020-04-24');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pno` int(11) NOT NULL,
  `pID` char(10) NOT NULL,
  `pName` varchar(40) NOT NULL,
  `dName` varchar(40) NOT NULL,
  `hName` varchar(40) NOT NULL,
  `pDate` date NOT NULL,
  `docCharge` double NOT NULL,
  `hosCharge` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pno`, `pID`, `pName`, `dName`, `hName`, `pDate`, `docCharge`, `hosCharge`, `total`) VALUES
(1, 'P001', 'Mevan Fernando', 'Binuri Samarathunga', 'Heelan', '2020-04-17', 1500, 200, 1700),
(2, 'P002', 'Kamal Sanjaya', 'Chanaka Galappaththi', 'Asiri Hospital', '2020-04-17', 2000, 150, 2150),
(3, 'P003', 'Sinali Senevirathne', 'Dilan Senarathna', 'Lanka Hospital', '2020-04-17', 2500, 500, 3000),
(8, 'P005', 'Rashmi Amarakoon', 'Athula Alvis', 'Pannipitiya Nursing Homel', '2020-04-18', 3000, 300, 3300),
(9, 'P004', 'Sunil Perera', 'Eshan Weerakoon', 'Durdans Hospital', '2020-04-18', 5000, 3000, 8000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`ano`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `ano` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `pno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
