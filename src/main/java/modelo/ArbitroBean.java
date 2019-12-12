package modelo;

public class ArbitroBean {

    private int id_a;
    private String nombre;
    private TorneoBean torneo;

    public ArbitroBean() {
    }

    public ArbitroBean(int id_a) {
        this.id_a = id_a;
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TorneoBean getTorneo() {
        return torneo;
    }

    public void setTorneo(TorneoBean torneo) {
        this.torneo = torneo;
    }
    
    
    
     

     
     
}
