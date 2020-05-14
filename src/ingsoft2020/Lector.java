package ingsoft2020;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

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
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(path_xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(path_xsd)));

            log.escribrirLog("Lector: Fichero validado con exito.");

        } catch (IOException | SAXException e) {
            log.escribrirLog("Lector: ERROR al validar el fichero de entrada.");
            log.escribrirLog("Lector: ruta xsd --> "+path_xsd);
            log.escribrirLog("Lector: ruta xml --> "+path_xml);
        }
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
