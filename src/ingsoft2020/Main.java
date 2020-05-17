package ingsoft2020;

public class Main {

    public static void main(String[] args) {

        //LOG
        Log lg = new Log();

        try {
            //LECTOR
            Lector lc = new Lector("./DATOS_ENTRADA.xml", "./DATOS_ESTRUCTURA.xsd", lg);
            lc.validadFichero(lc.getPath_xml(), lc.getPath_xsd()); //Validador funciona
            lc.leerFichero(lc.getPath_xml());
            lc.crearPais();

            //PAIS_HISTORICO
            Pais_Historico ph = new Pais_Historico();
            ph.addPais(lc.getPais()); //Pais_0

            //SIMULADOR
            Simulador sm = new Simulador(lc.getMaxDias(), lc.getE(), lc.getP(), lc.getV(), lg, lc.getPais(), ph);
            sm.calcularNdmas1(lc.getPais(), sm.calcularNv(lc.getPais())); //Recursivo

            //IMPRESORA
            Impresora imp = new Impresora(lg);
            imp.setCabecera("<!DOCTYPE html><html><head><style>table {font-family: arial, sans-serif;border-collapse: collapse;width: 100%;}td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;}tr:nth-child(even) {background-color: #dddddd;}</style></head><body><h1>Simulación de la expansión del virus</h1><br><h2>Pais</h2>");
            imp.setColumna("<tr><th>Dia</th><th>Poblacion total</th><th>Poblacion sana</th><th>Poblacion infectada</th><th>Porcentaje infectados</th></tr>");
            imp.crearContenido(ph.getLista_datos());
            imp.setPie("</body></html>");
            imp.imprimirSalida();

        }catch (Exception e){
            lg.escribrirLog("MAIN: ERROR --> "+e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println(lg.imprimirLog());
        }

    }
}
