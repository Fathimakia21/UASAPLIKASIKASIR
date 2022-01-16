/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umtas.uas;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class Produk {

    String id;
    String kodeProduk;
    String namaProduk;
    Integer qty;
    BigDecimal harga;

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public String getId() {
        return id;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public Integer getQty() {
        return qty;
    }




}