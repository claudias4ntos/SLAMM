/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class PremiojugadorBean {
    private int id_premio;
    private PartidoBean id_p;

    public PremiojugadorBean(int id_premio) {
        this.id_premio = id_premio;
    }

    public int getId_premio() {
        return id_premio;
    }

    public void setId_premio(int id_premio) {
        this.id_premio = id_premio;
    }

    public PartidoBean getId_p() {
        return id_p;
    }

    public void setId_p(PartidoBean id_p) {
        this.id_p = id_p;
    }
    
    
}
