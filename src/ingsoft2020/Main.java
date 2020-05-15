package ingsoft2020;

public class Main {

    public static void main(String[] args) {

        //LOG FUNCIONA
        Log lg = new Log();
        /*
        lg.escribrirLog("Primer comentario");
        lg.escribrirLog("Segundo comentario");
        lg.escribrirLog("Ultimo comentario");
        lg.imprimirLog();
        */

        //LECTOR
        Lector lc = new Lector("./DATOS_ENTRADA.xml","./DATOS_ESTRUCTURA.xsd",lg);
        lc.validadFichero(lc.getPath_xml(),lc.getPath_xsd()); //Validador funciona





        lg.imprimirLog();


    }


}
