/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.ModalidadDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ModalidadBean;

/**
 *
 * @author claudia.santosusam
 */
public class ModalidadServlet extends HttpServlet {

    Conexion conn = new Conexion();

    ModalidadDao mdao = new ModalidadDao(conn);
    List<ModalidadBean> listaMod = new LinkedList<>();
    RequestDispatcher rd;
    String msg = "";
    ModalidadBean moda;

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

        moda = new ModalidadBean();
        moda.setNombre(nombre);
        boolean res;
        res = mdao.insertar(moda);
        if (res) {
            msg = "registro insertado";

        } else {
            msg = "registro no insertado";
        }
        listaMod = mdao.listaMod();

        request.setAttribute("msg", msg);
        request.setAttribute("listaMod", mdao.listaMod());
        rd = request.getRequestDispatcher("/modalidad.jsp");
        rd.forward(request, response);

    }

    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_mod = Integer.parseInt(request.getParameter("id_mod"));
        boolean res = mdao.eliminar(id_mod);
        listaMod = mdao.listaMod();

        request.setAttribute("listaMod", mdao.listaMod());

        rd = request.getRequestDispatcher("/modalidad.jsp");
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
