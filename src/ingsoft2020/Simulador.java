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
        int nd1, nd1Total, cont;
        pais_dmas1 = new Pais();

        // Copiamos los datos del dia anterior
        for (Comunidad e : pais_d.getLista_comunidades()) {
            pais_dmas1.getLista_comunidades().add(new Comunidad(e.getNombre(),e.getPoblacion_total(),e.getPoblacion_sana(),e.getPoblacion_infectada(),e.getPorcetanje_infectados()));
        }

        // Si toca pais dia 1, se le asigna un infectado a una comunidad de manera aleatoria
        if(pais_historico.getLista_datos().size() == 1){
            int comunidadSeleccionada = (int)(Math.random()*pais_dmas1.getLista_comunidades().size());
            pais_dmas1.getLista_comunidades().get(comunidadSeleccionada).setPoblacion_infectada(1);
        }

        // Se calculan los infectados y sanos de cada comunidad y su porcentaje
        cont = 0;
        for (Comunidad e : pais_dmas1.getLista_comunidades()) {
            if(e.getPoblacion_infectada() < e.getPoblacion_total()) {
                nd1 = (int) Math.floor(e.getPoblacion_infectada() + (1 + E * P));
                nd1Total = nd1 + nv.get(cont++);
                if (nd1Total > e.getPoblacion_total()) nd1Total = e.getPoblacion_total();
                e.setPoblacion_infectada(nd1Total);
                e.setPoblacion_sana(e.getPoblacion_total() - nd1Total);
                e.setPorcetanje_infectados((e.getPoblacion_infectada() * 100 / e.getPoblacion_total()) + "%");
            }
        }

        // Se calculan lo infectados y sanos del pais y su porcentaje
        cont = 0;
        for (Comunidad e : pais_dmas1.getLista_comunidades()) {
            cont += e.getPoblacion_infectada();
            pais_dmas1.setPoblacion_infectada(cont);
            pais_dmas1.setPoblacion_sana(pais_dmas1.getPoblacion_total()-pais_dmas1.getPoblacion_infectada());
            pais_dmas1.setPorcetanje_infectados( (pais_dmas1.getPoblacion_infectada() * 100/pais_dmas1.getPoblacion_total())+"%" );
        }

    }

    public void calcularNv(Pais pais_d){
        nv = new ArrayList<>();
        int calculo;
        for (Comunidad e: pais_d.getLista_comunidades()) {
            calculo = Math.round( ( E*P*V*(e.getPoblacion_infectada()) )/e.getPoblacion_total() );
            nv.add(calculo);
        }
    }

}
