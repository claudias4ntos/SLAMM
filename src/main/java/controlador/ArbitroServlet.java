/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.ArbitroDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ArbitroBean;

public class ArbitroServlet extends HttpServlet {

    Conexion conn = new Conexion();
    ArbitroBean abean;
    ArbitroDao adao = new ArbitroDao(conn);
    List<ArbitroDao> listaArbitro = new LinkedList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insertar(request, response);
                break;
            case "consultar":
                consultar(request, response);
                break;
            case "consultarById":
                consultarById(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;

        }

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArbitroBean abean = new ArbitroBean();
        String msg = "";

        String nombre = request.getParameter("nombre");
        int torneo = Integer.parseInt(request.getParameter("id_torneo"));
        abean.0;
        
          
        
        
        

    }

    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
