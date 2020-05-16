package ingsoft2020;

import java.util.ArrayList;

public class Pais_Historico {

    private static ArrayList<Pais> lista_datos = new ArrayList<>();

    public Pais_Historico(){
    }

    public void addPais(Pais pais){
        lista_datos.add(pais);
    }

    public ArrayList<Pais> getLista_datos() {
        return lista_datos;
    }
}
