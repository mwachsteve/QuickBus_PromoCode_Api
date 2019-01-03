-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2019 at 08:58 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `dataop`
--

CREATE TABLE `dataop` (
  `id` int(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dataop`
--

INSERT INTO `dataop` (`id`, `username`, `password`) VALUES
(1, 'test', 'test'),
(2, '12', '12'),
(3, 'tred', 'tred'),
(4, '12', ''),
(5, '122', '11'),
(6, 'user', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `quickbus`
--

CREATE TABLE `quickbus` (
  `id` int(10) NOT NULL,
  `code` varchar(20) NOT NULL,
  `code_amount` varchar(30) NOT NULL,
  `fare` varchar(30) NOT NULL,
  `orig` varchar(40) NOT NULL,
  `dest` varchar(40) NOT NULL,
  `status` varchar(20) NOT NULL,
  `created_date` date NOT NULL,
  `expiry_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quickbus`
--

INSERT INTO `quickbus` (`id`, `code`, `code_amount`, `fare`, `orig`, `dest`, `status`, `created_date`, `expiry_date`) VALUES
(1, 'UFQE4VJU', '1000', '100', 'Nairobi', 'Mombasa', 'Active', '2018-12-31', '2019-04-01'),
(2, 'GQ6GKQ10', '1000', '100', 'ew', 'Mombasa', 'Active', '2018-12-31', '2019-02-02'),
(3, 'KYMF0X4I', '1000', '100', 'gf', 'Mombasa', 'Active', '2018-12-31', '2019-02-02'),
(4, 'SZ0LS0U2', '1000', '100', 'bg', 'Mombasa', 'Active', '2018-12-31', '2018-01-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dataop`
--
ALTER TABLE `dataop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quickbus`
--
ALTER TABLE `quickbus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dataop`
--
ALTER TABLE `dataop`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `quickbus`
--
ALTER TABLE `quickbus`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
