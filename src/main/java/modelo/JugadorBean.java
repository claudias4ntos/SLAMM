/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

public class JugadorBean {

    private int id_ju;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private String imagen;

    public JugadorBean(int id_ju) {
        this.id_ju = id_ju;
    }

    public int getId_ju() {
        return id_ju;
    }

    public void setId_ju(int id_ju) {
        this.id_ju = id_ju;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getImagen() {

        return imagen;

    }

    public void setImagen(String imagen) {

        this.imagen = imagen;
    }

}
