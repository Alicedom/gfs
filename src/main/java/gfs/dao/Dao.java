package gfs.dao;


import gfs.model.Gfs025;
import gfs.model.Station;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    private Connection conn = null;

    private String hostName = "172.16.0.252";
    private String dbName = "fieldclimate";
    private String userName = "root";
    private String password = "123456aA";
    private String dbURL = "jdbc:mysql://" + hostName + ":3306/" + dbName
            + "?useSSL=false&useUnicode=true&characterEncoding=utf8";


    public Connection getConn() {

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbURL, userName, password);
                System.out.println("Connecting...");
            } catch (SQLException ex) {
                System.err.println("Cannot connect database " + ex);
            }
        }

        return conn;
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
            e.printStackTrace();
        }

        return listStation;
    }


    public void saveHourlyData(List<Gfs025> gfs025List, String file){

        String sql = "INSERT INTO gfs025_hourly(station_code, time, update_time, dir, "
                + " humidity, temperature, temperature_surface, total_liquid, probability, uwind, vwind, wind_edge, "
                + " wind_direction)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";


        Connection conn = getConn();
        PreparedStatement statement = null;

        for (Gfs025 gfs: gfs025List)  {
            try {


                statement = conn.prepareStatement(sql);
//
                //log
                System.out.println("statement = " + statement.toString());

                statement.addBatch();
                statement.executeBatch();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
