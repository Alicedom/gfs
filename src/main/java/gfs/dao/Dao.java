package gfs.dao;



import gfs.controller.Utils;
import gfs.model.Gfs025;
import gfs.model.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.UnresolvedPermission;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;

public class Dao {

    private final static Logger logger = LoggerFactory.getLogger(Dao.class);
    private Connection conn = null;


    private String hostName = "localhost";
    private String dbName = "fieldclimate";
    private String userName = "root";
    private String password = "123456aA";
    private String dbURL = "jdbc:mysql://" + hostName + ":3306/" + dbName
            + "?useSSL=false&useUnicode=true&characterEncoding=utf8";


    public Dao() {
        getConn();
    }

    public Connection getConn() {

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbURL, userName, password);
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
            }
        }

        return conn;
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public ArrayList<Station> getStationEnalbeApi() {
        ArrayList<Station> listStation = new ArrayList<Station>();

        String sql = "SELECT * FROM station s WHERE s.api_enable = TRUE";

        Statement statement;

        try {
            Connection conn = getConn();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                String station_code = rs.getString("station_code");
                String station_name = rs.getString("station_name");
                String station_name_vi = rs.getString("station_name_vi");
                float lat = rs.getFloat("lat");
                float lon = rs.getFloat("lon");
                String accuweather_key = rs.getString("accuweather_key");

                Station station = new Station(station_code, station_name, station_name_vi, lat, lon, accuweather_key);
                listStation.add(station);
            }

            statement.close();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        logger.info("getnumber active station: "+listStation.size());

        return listStation;
    }

    public List<String> getAllDir() {
        List<String> stringArrayList = new ArrayList<String>();

        String sql = "SELECT DISTINCT (dir) FROM `gfs025_hourly` ORDER BY dir DESC";

        Statement statement;
        try {
            Connection conn = getConn();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                stringArrayList.add(rs.getString("dir"));
            }

            statement.close();
            conn.close();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }


        return stringArrayList;
    }

    public Map<String, Gfs025> getGfs025List(String update_time, int hour_data) {
        Map<String, Gfs025> gfs025List = new HashMap<String, Gfs025>();

        String sql = "SELECT * FROM gfs025_hourly g WHERE file = "+hour_data+" -- exam: get for after 5 hour" +
                " AND updated_time >= '"+ update_time+"' - INTERVAL 6 HOUR -- less than 1 interval for slow save" +
                " AND updated_time <  '"+update_time+"' -- get last data after that " +
                " GROUP BY g.station_code, g.time";

        Statement statement;

        try {
            Connection conn = getConn();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                String station_code = rs.getString("station_code");
                String time = rs.getString("time");
                String updated_time = rs.getString("updated_time");
                String dir = rs.getString("dir");
                String file = rs.getString("file");
                double humidity = rs.getDouble("humidity");
                double temperature = rs.getDouble("temperature");
                double temperature_surface = rs.getDouble("temperature_surface");
                double total_liquid = rs.getDouble("total_liquid");
                double probability = rs.getDouble("probability");
                double uwind = rs.getDouble("uwind");
                double vwind = rs.getDouble("vwind");
                double wind_speed = rs.getDouble("wind_speed");
                int wind_edge = rs.getInt("wind_edge");
                String wind_direct = rs.getString("wind_direction");


                Gfs025 gfs = new Gfs025(station_code,time,updated_time,dir,file,humidity,temperature,temperature_surface,total_liquid,uwind,vwind,wind_edge,wind_speed,wind_direct);
                gfs025List.put(station_code, gfs);
            }

            statement.close();


        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        logger.info("getnumber active station: "+gfs025List.size());

        return gfs025List;
    }


    public void saveHourlyData(List<Gfs025> gfs025List, String file) throws ParseException {

        String sql = "INSERT INTO gfs025_hourly(station_code, time, updated_time, dir, file,"
                + " humidity, temperature, temperature_surface, total_liquid, probability,"
                + " uwind, vwind, wind_speed, wind_edge, wind_direction)"
                + " VALUES (?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?);";


        Connection conn = getConn();
        PreparedStatement statement = null;

        for (Gfs025 gfs: gfs025List)  {
            try {
                statement = conn.prepareStatement(sql);
                statement.setString(1, gfs.getStationCode());
                statement.setString(2, Utils.getForecastTime(file));
                statement.setTimestamp(3, new Timestamp(Utils.getDate(file)));
                statement.setString(4, Utils.getDir(file));
                statement.setString(5,Utils.getFile(file));

                statement.setDouble(6, gfs.getRelative_humidity_height_above_ground());
                statement.setDouble(7, gfs.getTemperature_height_above_ground());
                statement.setDouble(8, gfs.getTemperature_surface());
                statement.setDouble(9, gfs.getTotal_precipitation_surface_1_Hour_Accumulation());
                statement.setDouble(10, 0);

                statement.setDouble(11, gfs.getUcomponent_of_wind_height_above_ground());
                statement.setDouble(12, gfs.getVcomponent_of_wind_height_above_ground());
                statement.setDouble(13, gfs.getWind_speed());
                statement.setDouble(14, gfs.getWind_degree());
                statement.setString(15, gfs.getWind_direct());

                statement.addBatch();
                statement.executeBatch();

            } catch (SQLException e) {
                logger.info(e.getMessage());
            }
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
