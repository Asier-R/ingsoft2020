package ingsoft2020;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
        pais = new Pais();
    }

    public void crearPais(String datos){
        // POR HACER
    }

    public void leerFichero(String path_xml){
        log.escribrirLog("Lector: Inicio de lectura del fichero xml.");
        log.escribrirLog("Lector: Ruta del fichero xml --> "+path_xml+" .");
        File file = new File(path_xml);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document doc;
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            doc.getDocumentElement().normalize();
            log.escribrirLog("Lector: Root element -->"+doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Comunidad");
            Node node;

            String E = doc.getElementsByTagName("E").item(0).getTextContent();
            String P = doc.getElementsByTagName("P").item(0).getTextContent();
            String V = doc.getElementsByTagName("V").item(0).getTextContent();
            log.escribrirLog("Lector: E->"+E+"\nP->"+P+"\nV->"+V);

            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    log.escribrirLog("Lector: Nombre comunidad -->"+eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    log.escribrirLog("Lector: Poblacion comunidad -->"+eElement.getElementsByTagName("poblacion").item(0).getTextContent());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.escribrirLog("Lector: ERROR en lectura del fichero xml.");
            log.escribrirLog("Lector: ERROR --> "+e.getMessage());
            e.printStackTrace();
        }

    }

    public void validadFichero(String path_xml,String path_xsd){
        log.escribrirLog("Lector: Inicio de validación.");
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(path_xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(path_xml)));

            log.escribrirLog("Lector: Fichero validado con exito.");

        } catch (IOException | SAXException e) {
            log.escribrirLog("Lector: ERROR al validar el fichero de entrada.");
            log.escribrirLog("Lector: ruta xsd --> "+path_xsd);
            log.escribrirLog("Lector: ruta xml --> "+path_xml);
        }
        log.escribrirLog("Lector: Fin de validación.");
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
