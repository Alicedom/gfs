package gfs.controller;

import gfs.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    final String saveFolder = "data/gfs025/";
    final int indexDir = 0;
    final int numberLink = 10;
    final int threadSize = 10;
    final int timeOut = 30;

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public Main() {
        try {
            new DownloadGfs025(indexDir, numberLink, threadSize, timeOut, saveFolder);
        }catch (ArithmeticException e){

        }
        String file = "data/gfs025/gfs.2018061406/1";
        Utils.getTimeforecastFromFileDir(file);
    }

    public static void main(String[] args) {

        try {
            new Main();
        }catch (Exception e){
            logger.error("Sorry, something wrong!", e);
        }
    }
}
