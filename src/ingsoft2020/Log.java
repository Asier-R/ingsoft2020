package ingsoft2020;

import java.sql.Timestamp;

public class Log {

    private static String log;
    private static String path_txt;
    private static StringBuilder sb;

    private Log(){
        // no se permite el uso
    }

    public Log(String path_txt){
        sb = new StringBuilder("//------ INICIO LOG  ------//");
        this.path_txt = path_txt;
    }

    public static void escribrirLog(String comentario){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        sb.append("\n"+ts.toString()+" - "+comentario);
    }

    public static String imprimirLog(){
        sb.append("\n//------ FINAL LOG  ------//");
        log = sb.toString();
        return log;
    }

    public static String getPath_txt() {
        return path_txt;
    }
}
