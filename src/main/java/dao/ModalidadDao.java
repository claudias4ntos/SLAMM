
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.ModalidadBean;


public class ModalidadDao {
    
    Conexion conn;
     PreparedStatement ps;
    public ModalidadDao(Conexion conn) {
        this.conn = conn;
    }
    
    
    public boolean insertar(ModalidadBean moda){
    String sql="insert into modalidad values(?,?)";
        try {
            ps= conn.conectar().prepareStatement(sql);
            ps.setInt(1, moda.getId_mod());
            ps.setString(2, moda.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }
    
     public List<ModalidadBean> listaMod() {
        ModalidadBean moda;
        
        List<ModalidadBean> lista = new LinkedList<>();

        String sql = "SELECT * FROM slam.modalidad;";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                moda = new ModalidadBean(rs.getInt("id_mod"));                                
                moda.setNombre(rs.getString("nombre"));      
                
                lista.add(moda);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }

    }
    public boolean eliminar(int id_mod){
        String sql="delete from modalidad where id_mod=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_mod);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
            
        }
    }
}
