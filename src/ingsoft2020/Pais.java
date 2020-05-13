package ingsoft2020;

import java.util.ArrayList;

public class Pais {

    private int poblacion_total;
    private int poblacion_sana;
    private int poblacion_infectada;
    private String porcetanje_infectados;
    private ArrayList<Comunidad> lista_comunidades;

    public Pais(){
        this.lista_comunidades = new ArrayList<>();
    }

    public Pais(int poblacion_total, int poblacion_sana, int poblacion_infectada, String porcetanje_infectados){
        this.lista_comunidades = new ArrayList<>();
        this.poblacion_total = poblacion_total;
        this.poblacion_sana = poblacion_sana;
        this.poblacion_infectada = poblacion_infectada;
        this.porcetanje_infectados = porcetanje_infectados;
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

    public ArrayList<Comunidad> getLista_comunidades() {
        return lista_comunidades;
    }

    public void setLista_comunidades(ArrayList<Comunidad> lista_comunidades) {
        this.lista_comunidades = lista_comunidades;
    }
}
