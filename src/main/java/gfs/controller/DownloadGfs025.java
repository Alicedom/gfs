package gfs.controller;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


public class DownloadGfs025 {

    private final static Logger logger = LoggerFactory.getLogger(DownloadGfs025.class);

    public DownloadGfs025(int indexDir, int numberLink, String saveFolder, int threadSize, int timeOut) {


        // bo file dau tien khong download????
        String dirFromURL = getDirFromURL(indexDir);
        logger.info("get last dir: " + dirFromURL);

        if (dirFromURL == null || dirFromURL == "") {
            logger.info("Not found dir on url");
        } else if (new File(saveFolder + dirFromURL).exists() && (new File(saveFolder + dirFromURL).listFiles().length == 3 * numberLink)) {
            logger.info(dirFromURL + " have enough data!!!");
        } else {
            List<String> list = getFileFromURL(numberLink, dirFromURL);
            //bo qua file anlytic
            list.remove(0);

            if (list.size() < numberLink) {
                logger.info(list.size() + " link  return do not enough: " + numberLink);
            } else {
                logger.info("get enough file: " + list.size());
                download(list, saveFolder, dirFromURL, threadSize, timeOut);
            }
        }

    }

    public void download(List<String> list, String saveFolder, String dirFromURL, int threadSize, int timeOut) {
        ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
        CompletionService<String> pool = new ExecutorCompletionService<String>(threadPool);

        for (int i = 0; i < list.size(); i++) {
            String path = saveFolder + dirFromURL + "/" + String.valueOf(i);
            if (new File(path).exists() && new File(path + ".gbx9").exists() && new File(path + ".ncx3").exists()) {
                //exist file
            } else {

                Callable<String> r = new DownloadFileCallable(list.get(i), path, timeOut);
                threadPool.submit(r);

            }
        }

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
            docDir = Jsoup.connect(urlDir).timeout(30000).get();
            lastDir = docDir.select("table > tbody > tr > td > a").get(indexDir).text().trim(); // back to second link

        } catch (IOException e) {
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
            fileURL = fileURL.replace("XXX", dir); // set dir
            Document fileDir = Jsoup.connect(urlPartFile + dir).timeout(30000).get();
            listFile = fileDir.select("body > form > p:nth-child(2) > select > option");

        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        if (listFile.size() < numberFilePerDir) {
            logger.info("Link do not enough file: " + listFile.size());
        } else {

            for (int i = 0; i <= numberFilePerDir; i++) {
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
                logger.info("download file: "+fileName);
                FileUtils.copyURLToFile(new URL(link), new File(fileName), timeout, timeout);
                new RawGfs025().save(fileName);
            } catch (IOException | ParseException e) {
                logger.error(e.getMessage());
            }

            return fileName;

        }
    }
}
