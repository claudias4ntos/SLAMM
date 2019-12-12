/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author claudia.santosusam
 */
public class ModalidadBean {
    private int id_mod;
    private String nombre;
    
    public ModalidadBean(){
    }

    public ModalidadBean(int id_mod) {
        this.id_mod = id_mod;
    }

    public int getId_mod() {
        return id_mod;
    }

    public void setId_mod(int id_mod) {
        this.id_mod = id_mod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
