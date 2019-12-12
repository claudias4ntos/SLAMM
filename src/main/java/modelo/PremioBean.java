/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class PremioBean {
   private int  id_premio;
private FaseBean id_fase;
private LugarBean id_lugar;
private double cantidad;

    public PremioBean(int id_premio) {
        this.id_premio = id_premio;
    }

    public int getId_premio() {
        return id_premio;
    }

    public void setId_premio(int id_premio) {
        this.id_premio = id_premio;
    }

    public FaseBean getId_fase() {
        return id_fase;
    }

    public void setId_fase(FaseBean id_fase) {
        this.id_fase = id_fase;
    }

    public LugarBean getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(LugarBean id_lugar) {
        this.id_lugar = id_lugar;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    
}
