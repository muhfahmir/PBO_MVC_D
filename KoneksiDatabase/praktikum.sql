-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Apr 2020 pada 03.53
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `praktikum`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`, `alamat`) VALUES
('123180001', 'Leni', 'Riau'),
('123180059', 'Muh Abel YP', 'Padang'),
('123180069', 'Febi Dwi A', 'Gombong Jaya'),
('123180075', 'Alexandromeo', 'Wonosobo'),
('123180091', 'Alya Salsabila', 'GlagahSari'),
('123180092', 'Atania', 'Jember'),
('123180093', 'Arsyalhaad KG', 'Semarang'),
('123180099', 'Agava Yonatan', 'Jambi'),
('123180107', 'Arief Satyatma', 'Maguwo'),
('123180108', 'Fahmi Rahmat', 'Yogya'),
('123180109', 'Julia Nur F', 'Krapyak'),
('123180110', 'Muh Nadif', 'Taman Siswa'),
('123180112', 'Naufal Rafif D', 'Kalasan'),
('123180115', 'Muh Afiq', 'Bekasi'),
('123180117', 'Dhio Fajriad', 'Padang'),
('123180118', 'Faisal Safana H', 'Wonosobo'),
('123180119', 'Khalil Attala', 'Padang'),
('123180134', 'Muh Al Akbar', 'Palembang'),
('123180180', 'Luqman Hadi', 'Dengung');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
