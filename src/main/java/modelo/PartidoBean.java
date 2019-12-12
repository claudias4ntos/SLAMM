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
public class PartidoBean {

    private int id_p;
    private String numero;
    private String resultado;
    private Date fecha;
    private TorneoBean torneo;
    private JugadorBean jugador;
    private ModalidadBean moda;
    private PremioBean premio;

    public PartidoBean() {
    }

    public PartidoBean(int id_p) {
        this.id_p = id_p;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TorneoBean getTorneo() {
        return torneo;
    }

    public void setTorneo(TorneoBean torneo) {
        this.torneo = torneo;
    }

    public JugadorBean getJugador() {
        return jugador;
    }

    public void setJugador(JugadorBean jugador) {
        this.jugador = jugador;
    }

    public ModalidadBean getModa() {
        return moda;
    }

    public void setModa(ModalidadBean moda) {
        this.moda = moda;
    }

    public PremioBean getPremio() {
        return premio;
    }

    public void setPremio(PremioBean premio) {
        this.premio = premio;
    }
    

  
}
