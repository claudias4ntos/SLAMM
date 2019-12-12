/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author claudia.santosusam
 */
public class EntrenadorBean {
private int id_ent;
private String nombre;
private Date fechai;
private Date fechaf;
private JugadorBean id_ju;

    public EntrenadorBean(int id_ent) {
        this.id_ent = id_ent;
    }

    public int getId_ent() {
        return id_ent;
    }

    public void setId_ent(int id_ent) {
        this.id_ent = id_ent;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public JugadorBean getId_ju() {
        return id_ju;
    }

    public void setId_ju(JugadorBean id_ju) {
        this.id_ju = id_ju;
    }

    
}
