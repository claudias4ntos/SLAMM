/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CiudadDao;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.PaisBean;

/**
 *
 * @author claudia.santosusam
 */
public class PisServlet extends HttpServlet {
Conexion conn = new Conexion();
    PaisDao pdao = new PaisDao(conn);
    List<PaisBean> listaPais = new LinkedList<>();
    RequestDispatcher rd;
    PaisBean pbean;
    String msg = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String action = request.getParameter("action");

        switch (action) {
            case "insertar":
                insertar(request, response);
                break;

          

            case "eliminar":
                eliminar(request, response);
                break;

        
        }
    
    
    }
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String nombre = request.getParameter("nombre");

        pbean = new PaisBean();
        pbean.setNombre(nombre);
        boolean res;
        res = pdao.insertar(pbean);
        if (res) {
            msg = "registro insertado";

        } else {
            msg = "registro no insertado";
        }
        listaPais = pdao.listaPaises();

        
        request.setAttribute("listaPaises", pdao.listaPaises());
        rd = request.getRequestDispatcher("/pais.jsp");
        rd.forward(request, response);

    }
    
    
      
      protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pais=Integer.parseInt(request.getParameter("id_pais"));
        
        boolean res=pdao.eliminar(id_pais);
        listaPais=pdao.listaPaises();
        
        request.setAttribute("msg", msg);
        request.setAttribute("listaPaises", pdao.listaPaises());
        rd = request.getRequestDispatcher("/pais.jsp");
        rd.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
