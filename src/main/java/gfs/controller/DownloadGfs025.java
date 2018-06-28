package gfs.controller;

import gfs.dao.Dao;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DownloadGfs025 {

    private final static Logger logger = LoggerFactory.getLogger(DownloadGfs025.class);

    public DownloadGfs025(int numberDir, int numberLink, String saveFolder, int threadSize, int timeOut) {
        ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);


        for (int indexDir = 0; indexDir < numberDir; indexDir++) {

            String dirFromURL = getDirFromURL(indexDir);

            if (dirFromURL == null || dirFromURL == "") {
                logger.info("Not found dir on url");
            } else if (new File(saveFolder + dirFromURL).exists() && (new File(saveFolder + dirFromURL).listFiles().length >= 3 * (numberLink-1))) {
                logger.info(dirFromURL + " have enough data!!!");
            } else {
                logger.info(" get dir " + dirFromURL);

                Dao dao = new Dao();
                Map<Integer, Integer> map = dao.getAllFile(dirFromURL);
                if (map.size() > numberLink) {
                    logger.info("data saved over");
                } else if (map.size() == numberLink) {
                    logger.info("data saved enough");
                } else {
                    logger.info(dirFromURL + " just have number hour: " + map.size());

                    List<String> list = getFileFromURL(numberLink, dirFromURL);

                    if (list == null || list.size() == 0) {
                        logger.info(list.size() + " link  return do not enough: " + (numberLink-1));
                    } else {
                        logger.info(dirFromURL + " number url " + list.size());

                        for (int i = 0; i < list.size() && i < numberLink; i++) {
                        if (map.containsKey(String.valueOf(i))) {
//                            System.out.println("have data");
                            } else {
                                String path = saveFolder + dirFromURL + "/" + String.valueOf(i);
                                if (new File(path).exists() && new File(path + ".gbx9").exists() && new File(path + ".ncx3").exists()) {
                                    // have file, just try to save data again
                                    new RawGfs025().save(path);
                                } else {
                                    // download and save
                                    Callable<String> r = new DownloadFileCallable(list.get(i), path, timeOut);
                                    threadPool.submit(r);
                                }
                            }
                        }
                    }
                }
                dao.close();

            }
        }

        logger.info("finish scan");

        threadPool.shutdown();
    }


    /*
    choose second:  take last url using jsoup
    Đơn giản, chính xác, chậm: toàn bộ link mất 3000ms
     */
    public String getDirFromURL(int indexDir) {
        final String urlDir = "http://nomads.ncep.noaa.gov/cgi-bin/filter_gfs_0p25.pl";

        String lastDir = null;
        try {
            Document docDir;
            docDir = Jsoup.connect(urlDir).timeout(300000).get();
            lastDir = docDir.select("table > tbody > tr > td > a").get(indexDir).text().trim(); // back to second link

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return lastDir;
    }

    public List<String> getFileFromURL(int numberFilePerDir, String dir) {
        List<String> linkedListURL = new LinkedList<String>();

        final String urlPartFile = "http://nomads.ncep.noaa.gov/cgi-bin/filter_gfs_0p25.pl?dir=%2F";
        String fileURL = "http://nomads.ncep.noaa.gov/cgi-bin/filter_gfs_0p25.pl?file=YYY" +
                "&lev_10_m_above_ground=on&lev_2_m_above_ground=on&lev_surface=on&var_APCP=on&var_RH=on&var_TMP=on&var_UGRD=on&var_VGRD=on" +
                "leftlon=102&rightlon=109&toplat=23&bottomlat=8&dir=%2FXXX";

        Elements listFile = null;
        try {
            Document fileDir = Jsoup.connect(urlPartFile + dir).timeout(300000).get();
            listFile = fileDir.select("body > form > p:nth-child(2) > select > option");

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (listFile == null || listFile.size() < 1) {
            // no file
        } else {

            // passed analitic file
            fileURL = fileURL.replace("XXX", dir); // set dir
            for (int i = 1; i < listFile.size(); i++) {
                String file = listFile.get(i).attr("value");
                String urlDownload = fileURL.replace("YYY", file); // set file
                linkedListURL.add(urlDownload);
            }
        }
        return linkedListURL;
    }

    private class DownloadFileCallable implements Callable<String> {

        private String link;
        private String fileName;
        private int timeout;

        public DownloadFileCallable(String link, String file, int timeout) {
            this.link = link;
            this.fileName = file;
            this.timeout = timeout;
        }

        public String call() {
            try {
                logger.info(fileName + " download and save data file: " + link);
                FileUtils.copyURLToFile(new URL(link), new File(fileName), timeout, timeout);
                new RawGfs025().save(fileName);
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            return fileName;
        }
    }
}
