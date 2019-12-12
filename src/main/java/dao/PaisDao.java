/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.PaisBean;

/**
 *
 * @author claudia.santosusam
 */
public class PaisDao {

    Conexion conn;

    public PaisDao(Conexion conn) {
        this.conn = conn;
    }

public boolean insertar(PaisBean cbean){
    String sql="insert into pais values(?,?)";
        try {
            PreparedStatement ps= conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getId_pais());
            ps.setString(2, cbean.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }

    /*
    public boolean insertar(TorneoBean tbean) {
        String sql = "insert into torneo values (?,?,?,?,?)";
        SimpleDateFormat formato = new SimpleDateFormat("yy-MM-dd");
        pbean = tbean.getId_pais();
        cbean = tbean.getId_ciudad();

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, tbean.getId_torneo());
            ps.setString(2, tbean.getNombre());
            ps.setString(3, formato.format(tbean.getAño()));
            ps.setInt(4, pbean.getId_pais());
            ps.setInt(5, cbean.getId_ciudad());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }

    }*/
    public List<PaisBean> listaPaises() {
        PaisBean pbean;
        List<PaisBean> lista = new LinkedList<>();

        String sql = "SELECT * FROM slam.pais;";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                pbean = new PaisBean(rs.getInt("id_pais"));
                pbean.setNombre(rs.getString("nombre"));

                lista.add(pbean);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }

    }
    public boolean eliminar(int id_pais){
    String sql="delete from pais where id_pais=?";
        try {
            PreparedStatement ps= conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_pais);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
            
}
