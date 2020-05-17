package ingsoft2020;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Log {

    private String log;
    private static String path_txt = "./Logs/";
    private static StringBuilder sb = new StringBuilder("------ INICIO LOG  ------"); //No presente en diseño original

    public Log(){
    }

    public void escribrirLog(String comentario){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        sb.append("\n"+ts.toString()+" - "+comentario);
    }

    public String imprimirLog(){
        sb.append("\n------ FINAL LOG  ------");
        log = sb.toString();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String filename = "LOG_"+ts.toString().replaceFirst("\\.[0-9]{3}","").replace(" ","_").replace(":","-");
        FileWriter fw;
        File f;

        try {
            filename = getPath_txt()+filename+".txt";
            f = new File(filename);
            fw = new FileWriter(f);
            fw.write(log);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            log = "LOG: ERROR --> "+e.getMessage();
        }

        return log;
    }

    public static String getPath_txt() {
        return path_txt;
    }
}
