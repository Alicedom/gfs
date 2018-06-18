package gfs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Field;

@Entity
@Table(name = "gfs025_hourly")
public class Gfs025 {


    private String stationCode;
    private double Relative_humidity_height_above_ground;
    private double Temperature_height_above_ground;
    private double Temperature_surface;
    private double Total_precipitation_surface_1_Hour_Accumulation;
    private double ucomponent_of_wind_height_above_ground;
    private double vcomponent_of_wind_height_above_ground;
    private double Wind_degree;
    private double Wind_speed;
    private String Wind_direct;

    private Field[] fields = Gfs025.class.getDeclaredFields();

    public void setObjectData(String name, double data){
//        if(name.equals("Relative_humidity_height_above_ground")){
//            setRelative_humidity_height_above_ground(data);
//        }else if(name.equals("Temperature_height_above_ground")){
//            setTemperature_height_above_ground(data);
//        }else if(name.equals("Temperature_surface")){
//            setTemperature_surface(data);
//        }else if(name.equals("Total_precipitation_surface_1_Hour_Accumulation")){
//            setTemperature_surface(data);
//        }else if(name.equals("u-component_of_wind_height_above_ground")){
//            setucomponent_of_wind_height_above_ground(data);
//        }else if(name.equals("v-component_of_wind_height_above_ground")){
//            setvcomponent_of_wind_height_above_ground(data);
//        }

        for (Field field: fields) {
            if(field.getName().equals(name.replace("-",""))){
                try {
                    field.setDouble(this,data);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Gfs025{" +
                "stationCode='" + stationCode + '\'' +
                ", Relative_humidity_height_above_ground=" + Relative_humidity_height_above_ground +
                ", Temperature_height_above_ground=" + Temperature_height_above_ground +
                ", Temperature_surface=" + Temperature_surface +
                ", Total_precipitation_surface_1_Hour_Accumulation=" + Total_precipitation_surface_1_Hour_Accumulation +
                ", ucomponent_of_wind_height_above_ground=" + ucomponent_of_wind_height_above_ground +
                ", vcomponent_of_wind_height_above_ground=" + vcomponent_of_wind_height_above_ground +
                ", Wind_degree=" + Wind_degree +
                ", Wind_speed=" + Wind_speed +
                ", Wind_direct='" + Wind_direct + '\'' +
                '}';
    }

    public void extractData(){
        calculateWindSpeed(ucomponent_of_wind_height_above_ground,vcomponent_of_wind_height_above_ground);
        calculateWindDegree(ucomponent_of_wind_height_above_ground,vcomponent_of_wind_height_above_ground);
        //need wind degree first
        calculateWindDirect(Wind_degree);
    }

    public void calculateWindSpeed(double u, double v){
        Wind_speed = Math.sqrt(u*u + v*v);
    }

    public void calculateWindDegree(double u, double v){
        Wind_degree = (270 - (180/Math.PI)*Math.atan2(v,u));
    }

    public void calculateWindDirect(double wind_degree){
        Wind_direct = SMSRule.smsGenerateElement(wind_degree, SMSRule.getGetWindDirectShortNameRule());
    }


    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public double getRelative_humidity_height_above_ground() {
        return Relative_humidity_height_above_ground;
    }

    public void setRelative_humidity_height_above_ground(double relative_humidity_height_above_ground) {
        Relative_humidity_height_above_ground = relative_humidity_height_above_ground;
    }

    public double getTemperature_height_above_ground() {
        return Temperature_height_above_ground;
    }

    public void setTemperature_height_above_ground(double temperature_height_above_ground) {
        Temperature_height_above_ground = temperature_height_above_ground;
    }

    public double getTemperature_surface() {
        return Temperature_surface;
    }

    public void setTemperature_surface(double temperature_surface) {
        Temperature_surface = temperature_surface;
    }

    public double getTotal_precipitation_surface_1_Hour_Accumulation() {
        return Total_precipitation_surface_1_Hour_Accumulation;
    }

    public void setTotal_precipitation_surface_1_Hour_Accumulation(double total_precipitation_surface_1_Hour_Accumulation) {
        Total_precipitation_surface_1_Hour_Accumulation = total_precipitation_surface_1_Hour_Accumulation;
    }

    public double getucomponent_of_wind_height_above_ground() {
        return ucomponent_of_wind_height_above_ground;
    }

    public void setucomponent_of_wind_height_above_ground(double ucomponent_of_wind_height_above_ground) {
        this.ucomponent_of_wind_height_above_ground = ucomponent_of_wind_height_above_ground;
    }

    public double getvcomponent_of_wind_height_above_ground() {
        return vcomponent_of_wind_height_above_ground;
    }

    public void setvcomponent_of_wind_height_above_ground(double vcomponent_of_wind_height_above_ground) {
        this.vcomponent_of_wind_height_above_ground = vcomponent_of_wind_height_above_ground;
    }

    public double getWind_degree() {
        return Wind_degree;
    }

    public void setWind_degree(double wind_degree) {
        Wind_degree = wind_degree;
    }

    public double getWind_speed() {
        return Wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        Wind_speed = wind_speed;
    }

    public String getWind_direct() {
        return Wind_direct;
    }

    public void setWind_direct(String wind_direct) {
        Wind_direct = wind_direct;
    }
}

