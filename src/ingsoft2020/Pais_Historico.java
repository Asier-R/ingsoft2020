package ingsoft2020;

import java.util.ArrayList;

public class Pais_Historico {

    private static ArrayList<Pais> lista_datos;

    public Pais_Historico(){
        lista_datos = new ArrayList<>();
    }

    public static void addPais(Pais pais){
        lista_datos.add(pais);
    }

    public static ArrayList<Pais> getLista_datos() {
        return lista_datos;
    }
}
