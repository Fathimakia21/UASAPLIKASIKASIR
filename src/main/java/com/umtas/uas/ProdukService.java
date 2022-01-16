/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umtas.uas;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ProdukService {

    DatabaseManager db = new DatabaseManager();

    public void save(Produk produk) {
        String query = String.format("INSERT INTO PRODUK (ID, KODE_PRODUK, NAMA_PRODUK, QTY, HARGA) VALUES ('%s', '%s', '%s','%s','%s')", produk.getId(), produk.getKodeProduk(), produk.getNamaProduk(), produk.getQty(), produk.getHarga());
        try {
            db.executeUpdate(query);

            System.out.println("Data " + this.toString() + " telah disimpan ke tabel PRODUK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data " + this.toString() + " gagal disimpan");
        }
    }

    public void update(Produk produk) {
        String query = String.format("UPDATE PRODUK SET KODE_PRODUK='%s', NAMA_PRODUK='%s', QTY='%s', HARGA='%s' WHERE ID='%s'", produk.getKodeProduk(), produk.getNamaProduk(), produk.getQty(), produk.getHarga(), produk.getId());
        try {
            db.executeUpdate(query);

            System.out.println("Data " + this.toString() + " telah diupdate ke tabel PRODUK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data " + this.toString() + " gagal diupdate");
        }
    }

    public void delete(Produk produk) {
        String query = String.format("DELETE PRODUK WHERE ID='%s'", produk.getId());
        try {
            db.executeUpdate(query);

            System.out.println("Data " + this.toString() + " telah dihapus dari tabel PRODUK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data " + this.toString() + " gagal dihapus");
        }
    }

    public List<Produk> getAllProduk() {
        List<Produk> ps = new ArrayList<Produk>();
        String query = String.format("SELECT * FROM PRODUK");
        try {
            List<Map<String, Object>> list = db.select(query, new String[]{"id", "kode_produk", "nama_produk", "qty", "harga"});

            for (Map<String, Object> m : list) {
                Produk p = new Produk();
                p.setId(String.valueOf(m.get("id")));
                p.setKodeProduk(String.valueOf(m.get("kode_produk")));
                p.setNamaProduk(String.valueOf(m.get("nama_produk")));
                p.setQty(Integer.valueOf(m.get("qty").toString()));
                p.setHarga(new BigDecimal(m.get("harga").toString()));
                ps.add(p);
            }
            System.out.println("Data produk berhasil di ambil " + ps);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data " + this.toString() + " gagal cari produk");
        }
        return ps;
    }
}
