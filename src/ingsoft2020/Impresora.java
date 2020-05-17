package ingsoft2020;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Impresora {

    private String cabecera;
    private String columna;
    private String contenido;
    private String pie;
    private static String path_html = "./datos_salida/";
    private Log log;
    //private Pais_Historico pais_historico;  // No es necesario

    private Impresora(){
        // no se permite su uso
    }

    public Impresora(Log log){
        this.log = log;
    }

    public void crearContenido(ArrayList<Pais> historico){
        log.escribrirLog("Impresora: Inicio de creacion de contenido.");
        StringBuilder sb = new StringBuilder();
        int cont = 0, numComunidades;
        String nombre;

        log.escribrirLog("Impresora: Inicio tabla pais.");

        // TABLA PAIS
        sb.append("<table>");
        sb.append(columna);
        for (Pais e: historico) {
            sb.append("<tr>");
            sb.append("<td>"+cont+"</td>");
            sb.append("<td>"+e.getPoblacion_total()+"</td>"); //no hay bajas, por lo que la poblacion total permanece constante.
            sb.append("<td>"+e.getPoblacion_sana()+"</td>");
            sb.append("<td>"+e.getPoblacion_infectada()+"</td>");
            sb.append("<td>"+e.getPorcetanje_infectados()+"</td>");
            sb.append("</tr>");
            cont++;
        }
        sb.append("</table>");
        sb.append("<br>");
        sb.append("<br>");

        log.escribrirLog("Impresora: Fin tabla pais e inicio tablas comunidad.");

        // TABLAS DE COMUNIDADES
        cont = 0;
        Comunidad comu;
        boolean cero = false;
        numComunidades = historico.get(0).getLista_comunidades().size();
        for (int i=0; i<numComunidades; i++){
            nombre = historico.get(0).getLista_comunidades().get(i).getNombre();
            log.escribrirLog("Impresora: Inicio comunidad --> "+nombre);

            sb.append("<h2>"+nombre+"</h2>");
            sb.append("<table>");
            sb.append(columna);

            for (Pais e: historico) {
                comu = e.getLista_comunidades().get(i);

                if(!cero) {
                    sb.append("<tr>");
                    sb.append("<td>" + cont + "</td>");
                    sb.append("<td>" + comu.getPoblacion_total() + "</td>");
                    sb.append("<td>" + comu.getPoblacion_sana() + "</td>");
                    sb.append("<td>" + comu.getPoblacion_infectada() + "</td>");
                    sb.append("<td>" + comu.getPorcetanje_infectados() + "</td>");
                    sb.append("</tr>");
                    cont++;
                }

                if(comu.getPoblacion_sana() == 0) cero = true;

            }

            cont = 0;
            cero = false;
            sb.append("</table>");
            sb.append("<br>");
            sb.append("<br>");

            log.escribrirLog("Impresora: Fin comunidad --> "+nombre);
        }

        setContenido(sb.toString());

        log.escribrirLog("Impresora: Fin creacion contenido.");
    }

    public void imprimirSalida(){
        log.escribrirLog("Impresora: Inicio de la impresión.");
        String impr = cabecera + contenido + pie;

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String filename = "DATOS_SALIDA_"+ts.toString().replaceFirst("\\.[0-9]{3}","").replace(" ","_").replace(":","-");
        FileWriter fw;
        File f;

        try {
            filename = getPath_html()+filename+".html";
            f = new File(filename);
            fw = new FileWriter(f);
            fw.write(impr);
            fw.close();
            log.escribrirLog("Impresora: Datos imprimidos con exito.");
        } catch (IOException e) {
            log.escribrirLog("IMPRESORA: ERROR --> "+e.getMessage());
            e.printStackTrace();
        }

        log.escribrirLog("Impresora: Fin de la impresión.");

    }

    public String getPath_html() {
        return path_html;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }
}
