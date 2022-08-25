-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 25 Ağu 2022, 21:18:55
-- Sunucu sürümü: 5.7.36
-- PHP Sürümü: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `daodb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `calisan`
--

DROP TABLE IF EXISTS `calisan`;
CREATE TABLE IF NOT EXISTS `calisan` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_isim` varchar(50) NOT NULL,
  `c_tc` varchar(11) NOT NULL,
  `c_tip` varchar(20) NOT NULL,
  `c_bolum` int(11) NOT NULL,
  `c_sifre` varchar(20) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `calisan`
--

INSERT INTO `calisan` (`c_id`, `c_isim`, `c_tc`, `c_tip`, `c_bolum`, `c_sifre`) VALUES
(1, 'emre çiftçi', '1', 'Doktor', 1, '1111'),
(2, 'Ahmet Melih', '1212121', 'Hasta', 3, 'ali'),
(3, 'veli', 'ali', 'Doktor', 50, '49'),
(5, 'mehmer', '1', 'Doktor', 1, '1'),
(6, 'faruk', '2', 'Hasta', 2, '22'),
(8, '3', '3', 'Hasta', 1, '34');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `clinic`
--

DROP TABLE IF EXISTS `clinic`;
CREATE TABLE IF NOT EXISTS `clinic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isim` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `clinic`
--

INSERT INTO `clinic` (`id`, `isim`) VALUES
(3, 'KBB'),
(2, 'kardiyoloji'),
(4, 'Dermotoloji2'),
(6, 'Farmotoloji');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `randevu`
--

DROP TABLE IF EXISTS `randevu`;
CREATE TABLE IF NOT EXISTS `randevu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hasta_id` int(11) NOT NULL,
  `doktor_id` int(11) NOT NULL,
  `klinik_id` int(11) NOT NULL,
  `tarih` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `randevu`
--

INSERT INTO `randevu` (`id`, `hasta_id`, `doktor_id`, `klinik_id`, `tarih`) VALUES
(2, 8, 5, 2, '22.08.2022'),
(3, 6, 3, 4, '22.08.202222'),
(4, 6, 5, 6, '27.08.2022'),
(5, 6, 1, 3, 'tarih gir:1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
