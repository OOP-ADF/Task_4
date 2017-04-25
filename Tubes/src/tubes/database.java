/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SagabAdi
 */
public class database {

    private String url = "jdbc:mysql://localhost/tubes";
    private String username = "root";
    private String pass = "";
    private Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, url, pass);
            con.setAutoCommit(false);
            System.out.println("Connected");
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Gagal Konek" + ex.getMessage());
        }
    }

    public void savePelanggan(Pelanggan p) {
        try {
            String query = "insert into pelanggan values ("
                    + "'" + p.getPk() + "','" + p.getId() + "','" + p.getNama() + "');";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Gagal save " + ex.getMessage());
        }
    }

    public void savePengemudi(Pengemudi p) {
        try {
            String query = "insert into pengemudi values ( "
                    + "'" + p.getPk() + "','" + p.getId() + "','" + p.getNama() + "');";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.commit();
            stmt.close();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public ArrayList<Pelanggan> loadPelanggan() {
        try {
            Pelanggan p;
            ArrayList<Pelanggan> pel = new ArrayList();
            String query = "select * from pelanggan;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String pk = rs.getString("pk_pel");
                String id = rs.getString("id");
                String nama = rs.getString("nama");
                p = new Pelanggan(nama, id, pk, pel.size() + 1);
                pel.add(p);
            }
            return pel;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error " + ex.getMessage());
        }
    }

    public ArrayList<Pengemudi> loadPengemudi() {
        try {
            Pengemudi p;
            ArrayList<Pengemudi> peng = new ArrayList();
            String query = "select * from pengemudi";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String pk = rs.getString("pk_peng");
                String id = rs.getString("id");
                String nama = rs.getString("nama");
                p = new Pengemudi(nama, id, pk);
                peng.add(p);
            }
            return peng;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Error" + ex.getMessage());
        }
    }
}
