package gfs.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date getDate(String dir){
        SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHH");
        Date date = null;
        try {
            date = formatter.parse(dir);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getCurTime(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date(System.currentTimeMillis()));
    }

    public static void checkAndCreateNewFile(String saveDir) {
        File log = new File(saveDir);

        if (log.getParentFile() != null && !log.getParentFile().exists()) {
            log.getParentFile().mkdirs();
        }
        if (!log.exists()) {
            try {
                log.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static String getTimeforecastFromFileDir(String file){

        String filename = file.substring(file.lastIndexOf("/")+1,file.length());

        String parentdir = new File(file).getParentFile().getName();
        String timedownload  = parentdir.substring(4,parentdir.length());
        Date date = Utils.getDate(timedownload);
        Timestamp timeforecast = new Timestamp(date.getTime()+3600*1000* Integer.parseInt(filename));
        return timeforecast.toString();
    }
}
