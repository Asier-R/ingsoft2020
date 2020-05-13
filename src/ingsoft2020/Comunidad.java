package ingsoft2020;

public class Comunidad {

    private String nombre;
    private int poblacion_total;
    private int poblacion_sana;
    private int poblacion_infectada;
    private String porcetanje_infectados;

    public Comunidad(String nombre, int poblacion_total, int poblacion_sana, int poblacion_infectada, String porcetanje_infectados){
        this.nombre = nombre;
        this.poblacion_total = poblacion_total;
        this.poblacion_sana = poblacion_sana;
        this.poblacion_infectada = poblacion_infectada;
        this.porcetanje_infectados = porcetanje_infectados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion_total() {
        return poblacion_total;
    }

    public void setPoblacion_total(int poblacion_total) {
        this.poblacion_total = poblacion_total;
    }

    public int getPoblacion_sana() {
        return poblacion_sana;
    }

    public void setPoblacion_sana(int poblacion_sana) {
        this.poblacion_sana = poblacion_sana;
    }

    public int getPoblacion_infectada() {
        return poblacion_infectada;
    }

    public void setPoblacion_infectada(int poblacion_infectada) {
        this.poblacion_infectada = poblacion_infectada;
    }

    public String getPorcetanje_infectados() {
        return porcetanje_infectados;
    }

    public void setPorcetanje_infectados(String porcetanje_infectados) {
        this.porcetanje_infectados = porcetanje_infectados;
    }

}
