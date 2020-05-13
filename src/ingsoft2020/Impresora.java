package ingsoft2020;

import java.util.ArrayList;

public class Impresora {

    private String cabecera;
    private String columna;
    private String contenido;
    private String pie;
    private String path_html;
    private Log log;
    private Pais_Historico pais_historico;

    private Impresora(){
        // no se permite su uso
    }

    public Impresora(String path_html,Log log,Pais_Historico pais_historico){
        this.path_html = path_html;
        this.log = log;
        this.pais_historico = pais_historico;
    }

    public void crearContenido(ArrayList<Pais> historico){
        // POR HACER
    }

    public void imprimirSalida(){
        // POR HACER
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
