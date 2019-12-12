
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.CiudadBean;


public class CiudadDao {
     Conexion conn;

     PreparedStatement ps;
    public CiudadDao(Conexion conn) {
        this.conn = conn;
    }
    
    
    public boolean insertar(CiudadBean cbean){
    String sql="insert into ciudad values(?,?)";
        try {
            ps= conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getId_ciudad());
            ps.setString(2, cbean.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }
    /*
    public boolean actualizar(CiudadBean cbean){
    String sql="update ciudad set nombre=? where id=?";
        try {
            ps= conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getId_ciudad());
            ps.setString(2, cbean.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }*/
      public List<CiudadBean> listaCiudad() {
        CiudadBean cbean;
        
        List<CiudadBean> lista = new LinkedList<>();

        String sql = "SELECT * FROM slam.ciudad;";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                cbean = new CiudadBean(rs.getInt("id_ciudad"));                                
                cbean.setNombre(rs.getString("nombre"));      
                
                lista.add(cbean);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }

    }
    public boolean eliminar(int id_ciudad){
        String sql="delete from ciudad where id_ciudad=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_ciudad);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    
    
    }
}
