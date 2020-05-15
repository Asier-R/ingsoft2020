package ingsoft2020;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Log {

    private static String log;
    private static String path_txt;
    private static StringBuilder sb;

    public Log(){
        sb = new StringBuilder("------ INICIO LOG  ------");
        this.path_txt = "./Logs/";
    }

    public Log(String path_txt){
        sb = new StringBuilder("------ INICIO LOG  ------");
        this.path_txt = path_txt;
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
            log = "ERROR: "+e.getMessage();
        }

        return log;
    }

    public static String getPath_txt() {
        return path_txt;
    }
}
