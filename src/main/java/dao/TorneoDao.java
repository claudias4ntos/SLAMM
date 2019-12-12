/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import modelo.CiudadBean;
import modelo.PaisBean;

import modelo.TorneoBean;

public class TorneoDao {

    Conexion conn;

    public TorneoDao(Conexion conn) {
        this.conn = conn;
    }
    CiudadBean cbean;
    PaisBean pbean;

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
            System.out.println("dao: " + tbean.getNombre() + " " + formato.format(tbean.getAño()) + " " + pbean.getId_pais());
            ps.executeUpdate();
            System.out.println("exito");
            return true;

        } catch (Exception e) {
            System.out.println("error dao");
            return false;
        }

    }

    public List<TorneoBean> listaTorneo() {
        TorneoBean tbean;
        List<TorneoBean> lista = new LinkedList<>();

        String sql = " select  t.id_torneo, t.nombre, t.año, t.id_pais, t.id_ciudad, p.nombre as pais, c.nombre as ciudad\n"
                + "                from torneo t\n"
                + "                inner join pais p on  t.id_pais=p.id_pais \n"
                + "                inner join ciudad c on t.id_ciudad=c.id_ciudad order by t.id_torneo";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tbean = new TorneoBean(rs.getInt("id_torneo"));
                pbean = new PaisBean(rs.getInt("id_pais"));
                cbean = new CiudadBean(rs.getInt("id_ciudad"));
                tbean.setNombre(rs.getString("nombre"));
                tbean.setAño(rs.getDate("año"));
                pbean.setNombre(rs.getString("pais"));
                cbean.setNombre(rs.getString("ciudad"));

                tbean.setId_pais(pbean);
                tbean.setId_ciudad(cbean);

                lista.add(tbean);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public List<TorneoBean> consultarById(int id_torneo) {
        TorneoBean tbean;
        List<TorneoBean> lista = new LinkedList<>();

        String sql = "select  t.id_torneo, t.nombre, t.año, t.id_pais, t.id_ciudad, p.nombre as pais, c.nombre as ciudad\n"
                + "					from torneo t\n"
                + "					inner join pais p on  t.id_pais=p.id_pais \n"
                + "					inner join ciudad c on t.id_ciudad=c.id_ciudad \n"
                + "                                        where t.id_torneo=?";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setInt(1, id_torneo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tbean = new TorneoBean(rs.getInt("id_torneo"));

                tbean.setNombre(rs.getString("nombre"));
                tbean.setAño(rs.getDate("año"));
                pbean = new PaisBean(rs.getInt("id_pais"));
                cbean = new CiudadBean(rs.getInt("id_ciudad"));
                pbean.setNombre(rs.getString("pais"));

                cbean.setNombre(rs.getString("ciudad"));

                tbean.setId_pais(pbean);
                tbean.setId_ciudad(cbean);

                lista.add(tbean);
                System.out.println(lista);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
     public boolean actualizar(TorneoBean tbean) {
        String sql = "update torneo set nombre = ?, año = ?, id_pais = ?,  id_ciudad = ? where id_torneo = ?";
        SimpleDateFormat formato = new SimpleDateFormat("yy-MM-dd");
        pbean = tbean.getId_pais();
        cbean = tbean.getId_ciudad();

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
           
            ps.setString(1, tbean.getNombre());
            ps.setString(2, formato.format(tbean.getAño()));
            ps.setInt(3, pbean.getId_pais());
            ps.setInt(4, cbean.getId_ciudad());
             ps.setInt(5, tbean.getId_torneo());
            System.out.println("dao: " + tbean.getNombre() + " " + formato.format(tbean.getAño()) + " " + pbean.getId_pais());
            ps.executeUpdate();
            System.out.println("exito");
            return true;

        } catch (Exception e) {
            System.out.println("error dao");
            return false;
        }

    }
     public boolean eliminar(int id_torneo){
     String sql ="delete from torneo where id_torneo=?";
         try {
             PreparedStatement ps=conn.conectar().prepareStatement(sql);
             ps.setInt(1, id_torneo);
             ps.executeUpdate();
             return true;
         } catch (Exception e) {
             return false;
         }
     
     }

}
