-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2023 at 09:15 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `Ssn` int(10) NOT NULL,
  `Fname` varchar(10) DEFAULT NULL,
  `Minit` varchar(1) DEFAULT NULL,
  `Lname` varchar(10) DEFAULT NULL,
  `Bdate` date DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Sex` varchar(1) DEFAULT NULL,
  `Salary` int(10) DEFAULT NULL,
  `Super_ssn` int(10) DEFAULT NULL,
  `Dno` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`Ssn`, `Fname`, `Minit`, `Lname`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES
(123456789, 'John', 'B', 'Smith', '1965-01-09', '731 Fondren, Houston, TX', 'M', 30000, 333445555, 5),
(333445555, 'Franklin', 'T', 'Wong', '1955-12-08', '638 Voss, Houston, TX', 'M', 40000, 888665555, 5),
(453453453, 'Joyce', 'A', 'English', '1972-07-31', '5631 Rice, Houston,  TX', 'F', 25000, 333445555, 5),
(666884444, 'Ramesh', 'K', 'Narayan', '1962-09-15', '975 Fire Oak, Humble, TX', 'M', 38000, 333445555, 5),
(888665555, 'James', 'E', 'Borg', '1937-11-10', '450 Stone, Houston. TX', 'M', 55000, NULL, 1),
(987654321, 'Jennifer', 'S', 'Wallace', '1941-06-20', '291 Berry, Bellaire, TX', 'F', 43000, 888665555, 4),
(987987987, 'Ahmad', 'V', 'Jabbar', '1969-03-29', '980 Dallas, Houston, TX', 'M', 25000, 987654321, 4),
(999887777, 'Alicia', 'J', 'Zelaya', '1968-01-19', '3321 Castle, Spring, TX', 'F', 25000, 987654321, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`Ssn`),
  ADD KEY `Super_ssn` (`Super_ssn`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `Cascade` FOREIGN KEY (`Super_ssn`) REFERENCES `employees` (`Ssn`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
