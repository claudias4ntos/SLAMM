/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CiudadDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CiudadBean;

/**
 *
 * @author claudia.santosusam
 */
public class CiudadServlet extends HttpServlet {

    Conexion conn = new Conexion();
    CiudadDao cdao = new CiudadDao(conn);
    List<CiudadBean> listaCiudad = new LinkedList<>();
    RequestDispatcher rd;
    CiudadBean cbean;
    String msg = "";

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

            case "eliminar":
                eliminar(request, response);
                break;

        }

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");

        cbean = new CiudadBean();
        cbean.setNombre(nombre);
        boolean res;
        res = cdao.insertar(cbean);
        if (res) {
            msg = "registro insertado";

        } else {
            msg = "registro no insertado";
        }
        listaCiudad = cdao.listaCiudad();

        request.setAttribute("msg", msg);
        request.setAttribute("listaCiudad", cdao.listaCiudad());
        rd = request.getRequestDispatcher("/ciudad.jsp");
        rd.forward(request, response);

    }

    /*  protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_ciudad = Integer.parseInt(request.getParameter("id_pais"));
        String nombre = request.getParameter("nombre");

        cbean = new CiudadBean();
        cbean.setNombre(nombre);
        boolean res;
        res = cdao.actualizar(cbean);
        if (res) {
            msg = "registro insertado";

        } else {
            msg = "registro no insertado";
        }

        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/ciudad.jsp");
        rd.forward(request, response);

    }
     */
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       /* listaCiudad = cdao.listaCiudad();
        RequestDispatcher rd;

        rd = request.getRequestDispatcher("/ciudad.jsp");
        rd.forward(request, response);*/

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_ciudad = Integer.parseInt(request.getParameter("id_ciudad"));

        boolean res = cdao.eliminar(id_ciudad);
        listaCiudad = cdao.listaCiudad();

        String msg = "";
        if (res) {
            msg = "registro eliminado";
        } else {
            msg = "registro no fue eliminado";
        }

        request.setAttribute("listaCiudad", cdao.listaCiudad());

        rd = request.getRequestDispatcher("/ciudad.jsp");
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
