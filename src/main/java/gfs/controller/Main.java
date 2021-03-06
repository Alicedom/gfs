package gfs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    private final static String saveFolder = "home/java/data/gfs025/";
    private final static int numberDir = 2;
    private final static int numberLink = 121;
    private final static int threadSize = 5;
    private final static int timeOut = 10000;

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable runnable = new MainRunnable(saveFolder, numberDir, numberLink, threadSize, timeOut);
        executorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.HOURS);
    }

    private static class MainRunnable implements Runnable {

        private String saveFolder;
        private int numberDir;
        private int numberLink;
        private int threadSize;
        private int timeOut;

        public MainRunnable(String saveFolder, int numberDir, int numberLink, int threadSize, int timeOut) {
            this.saveFolder = saveFolder;
            this.numberDir = numberDir;
            this.numberLink = numberLink;
            this.threadSize = threadSize;
            this.timeOut = timeOut;
        }

        @Override
        public void run() {
            logger.info("start job");
            new DownloadGfs025(numberDir, numberLink, saveFolder, threadSize, timeOut);

        }
    }


}
