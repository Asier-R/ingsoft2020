package ingsoft2020;

public class Lector {

    private String path_xml;
    private String path_xsd;
    private String datos;
    private Pais pais;
    private int maxDias;
    private float E;
    private float P;
    private float V;
    private Log log;

    private Lector(){
        // no se permite su uso
    }

    public Lector(String path_xml,String path_xsd,Log log){
        this.path_xml = path_xml;
        this.path_xsd = path_xsd;
        this.log = log;
    }

    public void crearPais(String datos){
        // POR HACER
    }

    public void leerFichero(String path_xml){
        // POR HACER
    }

    public void validadFichero(String path_xml,String path_xsd){
        // POR HACER
    }

    public String getDatos(){
        return datos;
    }

    public Pais getPais() {
        return pais;
    }

    public String getPath_xml() {
        return path_xml;
    }

    public String getPath_xsd() {
        return path_xsd;
    }

    public int getMaxDias() {
        return maxDias;
    }

    public float getE() {
        return E;
    }

    public float getP() {
        return P;
    }

    public float getV() {
        return V;
    }
}
