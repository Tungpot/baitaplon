-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2020 at 08:20 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `baikiemtra`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_monan`
--

CREATE TABLE IF NOT EXISTS `tbl_monan` (
  `anh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tbl_monan`
--

INSERT INTO `tbl_monan` (`anh`) VALUES
('abc'),
('31'),
('eqwe');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tuvung`
--

CREATE TABLE IF NOT EXISTS `tbl_tuvung` (
  `tentu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phanloai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nghia` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_tuvung`
--

INSERT INTO `tbl_tuvung` (`tentu`, `phanloai`, `nghia`) VALUES
('spring', 'danh tu', 'mua xuan'),
('Abide by', 'động từ', 'tuân thủ'),
('Agreement', 'danh từ', 'Sự thỏa thuân, hợp đồng'),
('Strong', 'Tính từ', 'Bền, vững, chăc chắn'),
('Competition', 'Danh từ_N', 'Sự cạnh tranh, cuộc thi đấu'),
('Convince', 'Động từ_V', 'Thuyết phục, làm cho tin'),
('Inspiration', 'Danh từ_N', 'Nguồn cảm hứng, sự thở\r\n'),
('Pesuasion', 'Danh từ_N', 'Sự thuyết phục, sự tin tưởng');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
