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

    public void crearPais(){//DISEÑO MODIFICADO --> parametro String datos, no es necesario
        log.escribrirLog("Lector: Creacion de pais dia 0.");

        int poblaTotal = 0;

        for (Comunidad e: pais.getLista_comunidades()) {
            poblaTotal += e.getPoblacion_total();
        }

        pais.setPoblacion_total(poblaTotal);
        pais.setPoblacion_sana(poblaTotal);
        pais.setPoblacion_infectada(0);
        pais.setPorcetanje_infectados("0%");

        log.escribrirLog("Lector: Fin de creacion de pais dia 0.");
        log.escribrirLog("Lector: Pais_0 poblacion total       --> "+pais.getPoblacion_total());
        log.escribrirLog("Lector: Pais_0 poblacion sana        --> "+pais.getPoblacion_sana());
        log.escribrirLog("Lector: Pais_0 poblacion infectada   --> "+pais.getPoblacion_infectada());
        log.escribrirLog("Lector: Pais_0 porcentaje infectados --> "+pais.getPorcetanje_infectados());

    }

    public void leerFichero(String path_xml){
        log.escribrirLog("Lector: Inicio de lectura del fichero xml.");
        log.escribrirLog("Lector: Ruta del fichero xml --> "+path_xml+" .");
        File file = new File(path_xml);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document doc;
        StringBuilder sb = new StringBuilder();
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            doc.getDocumentElement().normalize();
            log.escribrirLog("Lector: Root element -->"+doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Comunidad");
            Node node;

            E = Float.parseFloat( doc.getElementsByTagName("E").item(0).getTextContent() );
            P = Float.parseFloat( doc.getElementsByTagName("P").item(0).getTextContent() );
            V = Float.parseFloat( doc.getElementsByTagName("V").item(0).getTextContent() );
            maxDias = Integer.parseInt(doc.getElementsByTagName("maxDias").item(0).getTextContent());
            log.escribrirLog("Lector: E->"+E+"  P->"+P+"  V->"+V+"  maxDias->"+maxDias);

            String _comunidad;
            int _poblacion;

            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    _comunidad = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    _poblacion = Integer.parseInt(eElement.getElementsByTagName("poblacion").item(0).getTextContent());
                    log.escribrirLog("Lector: Comunidad -->"+_comunidad+"  Poblacion -->"+_poblacion);
                    pais.getLista_comunidades().add(new Comunidad(_comunidad,_poblacion,_poblacion,0,"0%"));
                    sb.append(_comunidad+":"+_poblacion+",");
                }
            }

            datos = sb.toString();

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
