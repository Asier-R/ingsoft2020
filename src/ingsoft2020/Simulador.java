package ingsoft2020;

import java.util.ArrayList;

public class Simulador {

    private Pais pais_d;
    private Pais pais_dmas1;
    private Pais_Historico pais_historico;
    private ArrayList<Integer> nv;
    private int maxDias;
    private float E;
    private float P;
    private float V;
    private Log log;

    private Simulador(){
        // no se permite su uso
    }

    public Simulador(int maxDias,float E,float P,float V,Log log){
        this.maxDias = maxDias;
        this.E = E;
        this.P = P;
        this.V = V;
        this.log = log;
    }

    public void calcularNdmas1(Pais pais_d,ArrayList<Integer> nv){
        // POR HACER
    }

    public void calcularNv(Pais pais_d){
        // POR HACER
    }

}
