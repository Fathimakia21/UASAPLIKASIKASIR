CREATE DATABASE KASIR;

USE KASIR;
CREATE TABLE `produk` (
  `id` varchar(45) NOT NULL,
  `kode_produk` varchar(45) DEFAULT NULL,
  `nama_produk` varchar(45) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `harga` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
