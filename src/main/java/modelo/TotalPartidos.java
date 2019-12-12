
package modelo;


public class TotalPartidos {
private  int  id_total;
  private TorneoBean id_torneo;

    public TotalPartidos(int id_total) {
        this.id_total = id_total;
    }

    public int getId_total() {
        return id_total;
    }

    public void setId_total(int id_total) {
        this.id_total = id_total;
    }

    public TorneoBean getId_torneo() {
        return id_torneo;
    }

    public void setId_torneo(TorneoBean id_torneo) {
        this.id_torneo = id_torneo;
    }
  
  
    
    
}
