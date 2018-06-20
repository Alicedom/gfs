package gfs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    private final static String saveFolder = "data/gfs025/";
    private final static int indexDir = 0;
    private final static int numberLink = 121;
    private final static int threadSize = 5;
    private final static int timeOut = 10000;


    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable runnable = new MainRunnable(saveFolder, indexDir, numberLink, threadSize, timeOut);
        executorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.HOURS);


    }

    private static class MainRunnable implements Runnable {

        private String saveFolder;
        private int indexDir;
        private int numberLink;
        private int threadSize;
        private int timeOut;

        public MainRunnable(String saveFolder, int indexDir, int numberLink, int threadSize, int timeOut) {
            this.saveFolder = saveFolder;
            this.indexDir = indexDir;
            this.numberLink = numberLink;
            this.threadSize = threadSize;
            this.timeOut = timeOut;
        }

        @Override
        public void run() {
            new DownloadGfs025(indexDir, numberLink, saveFolder, threadSize, timeOut);
            logger.info("index dir: "+indexDir);
        }
    }


}
