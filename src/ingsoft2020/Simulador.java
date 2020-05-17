package ingsoft2020;

import java.util.ArrayList;

public class Simulador {

    //private Pais pais_d; //No es necesario
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

    public Simulador(int maxDias,float E,float P,float V,Log log, Pais pais_0, Pais_Historico pais_historico){
        this.maxDias = maxDias;
        this.E = E;
        this.P = P;
        this.V = V;
        this.log = log;
        //this.pais_d = pais_0;
        this.pais_historico = pais_historico;
    }

    public void calcularNdmas1(Pais pais_d,ArrayList<Integer> nv){
        int nd1, nd1Total, cont, pI, pT;
        pais_dmas1 = new Pais();

        log.escribrirLog("Simulador: calcularNdmas1 dia --> "+pais_historico.getLista_datos().size()+"   maxDias --> "+maxDias);
        log.escribrirLog("Simulador: Datos de pais");
        log.escribrirLog("Simulador: poblacion total                 --> "+pais_d.getPoblacion_total());
        log.escribrirLog("Simulador: poblacion sana                  --> "+pais_d.getPoblacion_sana());
        log.escribrirLog("Simulador: poblacion infectada             --> "+pais_d.getPoblacion_infectada());
        log.escribrirLog("Simulador: poblacion porcentaje infectados --> "+pais_d.getPorcetanje_infectados());

        // Copiamos los datos del dia anterior
        for (Comunidad e : pais_d.getLista_comunidades()) {
            pais_dmas1.getLista_comunidades().add(new Comunidad(e.getNombre(),e.getPoblacion_total(),e.getPoblacion_sana(),e.getPoblacion_infectada(),e.getPorcetanje_infectados()));
        }

        log.escribrirLog("Simulador: Se ha creado pais_dmas1.");

        // Si toca pais dia 1, se le asigna un infectado a una comunidad de manera aleatoria
        if(pais_historico.getLista_datos().size() == 1){
            int comunidadSeleccionada = (int)(Math.random()*pais_dmas1.getLista_comunidades().size());
            pais_dmas1.getLista_comunidades().get(comunidadSeleccionada).setPoblacion_infectada(1);
            log.escribrirLog("Simulador: Aparece el primer infectado.");
        }

        // Se calculan los infectados y sanos de cada COMUNIDAD y su porcentaje
        cont = 0;
        for (Comunidad e : pais_dmas1.getLista_comunidades()) {
            if(e.getPoblacion_infectada() < e.getPoblacion_total()) {
                nd1 = (int) Math.floor(e.getPoblacion_infectada() + (1 + E * P));
                nd1Total = nd1 + nv.get(cont++);
                if (nd1Total > e.getPoblacion_total()) nd1Total = e.getPoblacion_total(); // Evitar superar la poblacion total
                e.setPoblacion_infectada(nd1Total);
                e.setPoblacion_sana(e.getPoblacion_total() - nd1Total);
                e.setPorcetanje_infectados((e.getPoblacion_infectada() * 100 / e.getPoblacion_total()) + "%");
            }
        }

        log.escribrirLog("Simulador: Calculos de comunidad realizados.");

        // Se calculan lo infectados y sanos del PAIS y su porcentaje
        pI = 0;
        pT = 0;
        for (Comunidad e : pais_dmas1.getLista_comunidades()) {
            pT += e.getPoblacion_total();
            pI += e.getPoblacion_infectada();
        }
        pais_dmas1.setPoblacion_total(pT);
        pais_dmas1.setPoblacion_infectada(pI);
        pais_dmas1.setPoblacion_sana(pais_dmas1.getPoblacion_total()-pais_dmas1.getPoblacion_infectada());
        pais_dmas1.setPorcetanje_infectados( (pais_dmas1.getPoblacion_infectada() * 100/pais_dmas1.getPoblacion_total())+"%" );

        log.escribrirLog("Simulador: Calculos de pais_dmas1 realizados.");

        //Se añade el nuevo pais al historioco
        pais_historico.addPais(pais_dmas1);

        if(pais_historico.getLista_datos().size() < maxDias && pais_dmas1.getPoblacion_sana()>0){
            log.escribrirLog("Simulador: Llamada recursiva para calcular siguiente dia.");
            calcularNdmas1(pais_dmas1,calcularNv(pais_dmas1));
        }else{
            log.escribrirLog("Simulador: Fin de calculos.");
        }

    }

    public ArrayList<Integer> calcularNv(Pais pais_d){
        log.escribrirLog("Simulador: Se inicia calculo de infectados por viajeros.");
        nv = new ArrayList<>();
        int calculo;
        for (Comunidad e: pais_d.getLista_comunidades()) {
            calculo = Math.round( ( E*P*V*(e.getPoblacion_infectada()) )/e.getPoblacion_total() );
            nv.add(calculo);
        }
        log.escribrirLog("Simulador: Se han calculado infectados por viajeros.");
        return nv;
    }

}
