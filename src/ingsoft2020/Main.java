package ingsoft2020;

public class Main {

    public static void main(String[] args) {

        //LOG
        Log lg = new Log();

        //LECTOR
        Lector lc = new Lector("./DATOS_ENTRADA.xml","./DATOS_ESTRUCTURA.xsd",lg);
        lc.validadFichero(lc.getPath_xml(),lc.getPath_xsd()); //Validador funciona
        lc.leerFichero(lc.getPath_xml());
        lc.crearPais();

        //PAIS_HISTORICO
        Pais_Historico ph = new Pais_Historico();
        ph.addPais(lc.getPais()); //Pais_0

        //SIMULADOR
        Simulador sm = new Simulador(lc.getMaxDias(),lc.getE(),lc.getP(),lc.getV(),lg);






        lg.imprimirLog();


    }


}
