/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import conexion.Conexion;
import dao.CiudadDao;
import dao.PaisDao;
import dao.TorneoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CiudadBean;
import modelo.PaisBean;
import modelo.TorneoBean;

public class TorneoServlet extends HttpServlet {

    RequestDispatcher rd;
    List<TorneoBean> lista = new LinkedList<>();
    List<PaisBean> listaPais = new LinkedList<>();
    List<CiudadBean> listaCiudad = new LinkedList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String action = request.getParameter("action");

        switch (action) {

            case "insertar":
                insertar(request, response);

                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "consultar":
                consultar(request, response);
                break;
            case "consultarById":
                consultarById(request, response);
                break;

            case "llenar":
                llenar(request, response);
                break;
            case "consultarCiudad":
                consultarCiudad(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;

        }

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        TorneoDao tdao = new TorneoDao(conn);
        TorneoBean tbean = new TorneoBean(0);
        PaisBean pbean = new PaisBean(0);
        CiudadBean cbean = new CiudadBean(0);

        String nombre = request.getParameter("nombre");

        int id_pais = Integer.parseInt(request.getParameter("id_pais"));
        pbean.setId_pais(id_pais);
        int id_ciudad = Integer.parseInt(request.getParameter("id_ciudad"));
        cbean.setId_ciudad(id_ciudad);

        tbean.setNombre(nombre);
        tbean.setId_pais(pbean);
        tbean.setId_ciudad(cbean);
        System.out.println(tbean.getNombre() + " " + pbean.getId_pais());
        boolean res;
        String msg = "";

        res = tdao.insertar(tbean);
        if (res) {
            msg = "registro guadado";
            System.out.println("insertado");
        } else {
            msg = "registro no fue guardado ";

        }

        PaisDao pdao = new PaisDao(conn);

        CiudadDao cdao = new CiudadDao(conn);

        request.setAttribute("listaPais", pdao.listaPaises());
        request.setAttribute("listaCiudad", cdao.listaCiudad());

        listaCiudad = cdao.listaCiudad();
        listaPais = pdao.listaPaises();
        lista = tdao.listaTorneo();
        request.setAttribute("lista", lista);

        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/torneo.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Conexion conn = new Conexion();
        SimpleDateFormat formato = new SimpleDateFormat("yy-MM-dd");
        PaisDao pdao = new PaisDao(conn);

        CiudadDao cdao = new CiudadDao(conn);

        TorneoDao tdao = new TorneoDao(conn);

        PaisBean pbean = new PaisBean();
        CiudadBean cbean = new CiudadBean();

        int id_torneo = Integer.parseInt(request.getParameter("id_torneo"));

        String nombre = request.getParameter("nombre");
        Date anio = formato.parse(request.getParameter("anio"));
        System.out.println(anio);
        int id_pais = Integer.parseInt(request.getParameter("id_pais"));
        pbean.setId_pais(id_pais);
        int id_ciudad = Integer.parseInt(request.getParameter("id_ciudad"));
        cbean.setId_ciudad(id_ciudad);

        TorneoBean tbean = new TorneoBean(id_torneo);

        tbean.setNombre(nombre);
        tbean.setId_pais(pbean);
        tbean.setId_ciudad(cbean);
        tbean.setAño(anio);
        System.out.println("servlet " + tbean.getAño());
        boolean res;
        String msg = "";

        res = tdao.actualizar(tbean);
        lista = tdao.listaTorneo();
        if (res) {
            msg = "registro actualizado";
            System.out.println("insertado");
        } else {
            msg = "registro no fue actualizado ";

        }
        listaCiudad = cdao.listaCiudad();
        listaPais = pdao.listaPaises();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/torneo.jsp");
        rd.forward(request, response);

    }

    protected void llenar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        PaisBean pbean = new PaisBean(0);
        PaisDao pdao = new PaisDao(conn);
        CiudadDao cdao = new CiudadDao(conn);
        TorneoDao tdao = new TorneoDao(conn);
        lista = tdao.listaTorneo();
        request.setAttribute("lista", lista);
        request.setAttribute("listaPais", pdao.listaPaises());
        request.setAttribute("listaCiudad", cdao.listaCiudad());
        rd = request.getRequestDispatcher("/torneo.jsp");
        rd.forward(request, response);

    }

    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoBean tbean = new TorneoBean(0);
        TorneoDao tdao = new TorneoDao(conn);

        PaisDao pdao = new PaisDao(conn);
        CiudadDao cdao = new CiudadDao(conn);

        lista = tdao.listaTorneo();

        request.setAttribute("lista", lista);
        request.setAttribute("listaPais", pdao.listaPaises());
        request.setAttribute("listaCiudad", cdao.listaCiudad());
        rd = request.getRequestDispatcher("/torneo.jsp");
        rd.forward(request, response);

    }

    protected void consultarCiudad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        CiudadBean pbean = new CiudadBean(0);
        CiudadDao cdao = new CiudadDao(conn);

        listaCiudad = cdao.listaCiudad();
        RequestDispatcher rd;

        rd = request.getRequestDispatcher("/torneo.jsp");
        rd.forward(request, response);

    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        TorneoDao tdao = new TorneoDao(conn);
        PaisDao pdao = new PaisDao(conn);
        CiudadDao cdao = new CiudadDao(conn);

        int id_torneo = Integer.parseInt(request.getParameter("id_torneo"));

        lista = tdao.consultarById(id_torneo);

        request.setAttribute("listaPais", pdao.listaPaises());
        request.setAttribute("listaCiudad", cdao.listaCiudad());
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/actualizarTorneo.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoDao tdao = new TorneoDao(conn);
        PaisDao pdao = new PaisDao(conn);
        CiudadDao cdao = new CiudadDao(conn);

        int id_torneo = Integer.parseInt(request.getParameter("id_torneo"));

        boolean res = tdao.eliminar(id_torneo);
        lista = tdao.listaTorneo();
        String msg = "";
        if (res) {
            msg = "registro eliminado";
        } else {
            msg = "registro no fue eliminado";
        }

        request.setAttribute("listaPais", pdao.listaPaises());
        request.setAttribute("listaCiudad", cdao.listaCiudad());
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/torneo.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TorneoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TorneoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
