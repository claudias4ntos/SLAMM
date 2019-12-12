/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

public class TorneoBean {

    private int id_torneo;
    private String nombre;
    private Date año;
    private PaisBean id_pais;
    private CiudadBean id_ciudad;
    
///variables de impresion
   
    
    public TorneoBean(int id_torneo) {
        this.id_torneo = id_torneo;
       this.año = new Date();
    }

    public int getId_torneo() {
        return id_torneo;
    }

    public void setId_torneo(int id_torneo) {
        this.id_torneo = id_torneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    public PaisBean getId_pais() {
        return id_pais;
    }

    public void setId_pais(PaisBean id_pais) {
        this.id_pais = id_pais;
    }

    public CiudadBean getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(CiudadBean id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

}
