package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static String user = "root";
    static String pass = "root";
    static String db = "slam";
    static String url = "jdbc:mysql://localhost/"+db+"?useSSL=false";
    Connection conn;

    public  Conexion(){
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                conn= DriverManager.getConnection(url, user, pass);
                
                
                if (conn !=null) {
                    System.out.println("exito conexion");
                    
                    
                }else{
                    System.out.println("error");
                }
                
            } catch (Exception e) {
            }
 
    }

    public  Connection conectar(){
        
        return conn;

    }
    public void desconectar() throws SQLException {
 
        
      conn.close();
    
    }
    
     public static void main(String[] args) {
        Conexion conn= new Conexion();
        conn.conectar();
    }
    
}
