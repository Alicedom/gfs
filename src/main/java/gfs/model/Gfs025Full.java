package gfs.model;

import java.lang.reflect.Field;

public class Gfs025Full extends Gfs025 {
//    private final Field[] fields = Gfs025Full.class.getDeclaredFields();

    private double Albedo_surface_2_Hour_Average;
    private double Apparent_temperature_height_above_ground;
    private double Cloud_water_entire_atmosphere_single_layer;
    private double Convective_available_potential_energy_surface;
    private double Convective_inhibition_surface;
    private double Convective_precipitation_surface_2_Hour_Accumulation;
    private double Dewpoint_temperature_height_above_ground;
    private double Geopotential_height_maximum_wind;
    private double Geopotential_height_surface;
    private double Haines_index_surface;
    private double ICAO_Standard_Atmosphere_Reference_Height_maximum_wind;
    private double Ice_cover_surface;
    private double Land_cover_0__sea_1__land_surface;
    private double Latent_heat_net_flux_surface_2_Hour_Average;
    private double Maximum_temperature_height_above_ground_2_Hour_Maximum;
    private double Minimum_temperature_height_above_ground_2_Hour_Minimum;
    private double Momentum_flux_ucomponent_surface_2_Hour_Average;
    private double Momentum_flux_vcomponent_surface_2_Hour_Average;
    private double Per_cent_frozen_precipitation_surface;
    private double Precipitable_water_entire_atmosphere_single_layer;
    private double Precipitation_rate_surface_2_Hour_Average;
    private double Pressure_maximum_wind;
    private double Pressure_surface;
    private double Relative_humidity_height_above_ground;
    private double Relative_humidity_entire_atmosphere_single_layer;
    private double Sensible_heat_net_flux_surface_2_Hour_Average;
    private double Snow_depth_surface;
    private double Specific_humidity_height_above_ground;
    private double Temperature_maximum_wind;
    private double Temperature_height_above_ground;
    private double Temperature_surface;
    private double Total_cloud_cover_entire_atmosphere_2_Hour_Average;
    private double Total_ozone_entire_atmosphere_single_layer;
    private double Total_precipitation_surface_2_Hour_Accumulation;
    private double Categorical_Rain_surface_2_Hour_Average;
    private double Categorical_Freezing_Rain_surface_2_Hour_Average;
    private double Categorical_Ice_Pellets_surface_2_Hour_Average;
    private double Categorical_Snow_surface_2_Hour_Average;
    private double Convective_Precipitation_Rate_surface_2_Hour_Average;
    private double Potential_Evaporation_Rate_surface;
    private double Zonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average;
    private double Meridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average;
    private double Planetary_Boundary_Layer_Height_surface;
    private double Downward_ShortWave_Radiation_Flux_surface_2_Hour_Average;
    private double Upward_ShortWave_Radiation_Flux_surface_2_Hour_Average;
    private double Downward_LongWave_Radp_Flux_surface_2_Hour_Average;
    private double Upward_LongWave_Radp_Flux_surface_2_Hour_Average;
    private double Cloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average;
    private double Sunshine_Duration_surface;
    private double Surface_Lifted_Index_surface;
    private double Best_4_layer_Lifted_Index_surface;
    private double Ground_Heat_Flux_surface_2_Hour_Average;
    private double Wilting_Point_surface;
    private double Landsea_coverage_nearest_neighbor_land1sea0_surface;
    private double Field_Capacity_surface;
    private double Visibility_surface;
    private double Water_equivalent_of_accumulated_snow_depth_surface;
    private double Water_runoff_surface_2_Hour_Accumulation;
    private double Wind_speed_gust_surface;
    private double ucomponent_of_wind_maximum_wind;
    private double ucomponent_of_wind_height_above_ground;
    private double vcomponent_of_wind_maximum_wind;
    private double vcomponent_of_wind_height_above_ground;

    public double getAlbedo_surface_2_Hour_Average() {
        return Albedo_surface_2_Hour_Average;
    }

    public void setAlbedo_surface_2_Hour_Average(double albedo_surface_2_Hour_Average) {
        Albedo_surface_2_Hour_Average = albedo_surface_2_Hour_Average;
    }

    public double getApparent_temperature_height_above_ground() {
        return Apparent_temperature_height_above_ground;
    }

    public void setApparent_temperature_height_above_ground(double apparent_temperature_height_above_ground) {
        Apparent_temperature_height_above_ground = apparent_temperature_height_above_ground;
    }

    public double getCloud_water_entire_atmosphere_single_layer() {
        return Cloud_water_entire_atmosphere_single_layer;
    }

    public void setCloud_water_entire_atmosphere_single_layer(double cloud_water_entire_atmosphere_single_layer) {
        Cloud_water_entire_atmosphere_single_layer = cloud_water_entire_atmosphere_single_layer;
    }

    public double getConvective_available_potential_energy_surface() {
        return Convective_available_potential_energy_surface;
    }

    public void setConvective_available_potential_energy_surface(double convective_available_potential_energy_surface) {
        Convective_available_potential_energy_surface = convective_available_potential_energy_surface;
    }

    public double getConvective_inhibition_surface() {
        return Convective_inhibition_surface;
    }

    public void setConvective_inhibition_surface(double convective_inhibition_surface) {
        Convective_inhibition_surface = convective_inhibition_surface;
    }

    public double getConvective_precipitation_surface_2_Hour_Accumulation() {
        return Convective_precipitation_surface_2_Hour_Accumulation;
    }

    public void setConvective_precipitation_surface_2_Hour_Accumulation(double convective_precipitation_surface_2_Hour_Accumulation) {
        Convective_precipitation_surface_2_Hour_Accumulation = convective_precipitation_surface_2_Hour_Accumulation;
    }

    public double getDewpoint_temperature_height_above_ground() {
        return Dewpoint_temperature_height_above_ground;
    }

    public void setDewpoint_temperature_height_above_ground(double dewpoint_temperature_height_above_ground) {
        Dewpoint_temperature_height_above_ground = dewpoint_temperature_height_above_ground;
    }

    public double getGeopotential_height_maximum_wind() {
        return Geopotential_height_maximum_wind;
    }

    public void setGeopotential_height_maximum_wind(double geopotential_height_maximum_wind) {
        Geopotential_height_maximum_wind = geopotential_height_maximum_wind;
    }

    public double getGeopotential_height_surface() {
        return Geopotential_height_surface;
    }

    public void setGeopotential_height_surface(double geopotential_height_surface) {
        Geopotential_height_surface = geopotential_height_surface;
    }

    public double getHaines_index_surface() {
        return Haines_index_surface;
    }

    public void setHaines_index_surface(double haines_index_surface) {
        Haines_index_surface = haines_index_surface;
    }

    public double getICAO_Standard_Atmosphere_Reference_Height_maximum_wind() {
        return ICAO_Standard_Atmosphere_Reference_Height_maximum_wind;
    }

    public void setICAO_Standard_Atmosphere_Reference_Height_maximum_wind(double ICAO_Standard_Atmosphere_Reference_Height_maximum_wind) {
        this.ICAO_Standard_Atmosphere_Reference_Height_maximum_wind = ICAO_Standard_Atmosphere_Reference_Height_maximum_wind;
    }

    public double getIce_cover_surface() {
        return Ice_cover_surface;
    }

    public void setIce_cover_surface(double ice_cover_surface) {
        Ice_cover_surface = ice_cover_surface;
    }

    public double getLand_cover_0__sea_1__land_surface() {
        return Land_cover_0__sea_1__land_surface;
    }

    public void setLand_cover_0__sea_1__land_surface(double land_cover_0__sea_1__land_surface) {
        Land_cover_0__sea_1__land_surface = land_cover_0__sea_1__land_surface;
    }

    public double getLatent_heat_net_flux_surface_2_Hour_Average() {
        return Latent_heat_net_flux_surface_2_Hour_Average;
    }

    public void setLatent_heat_net_flux_surface_2_Hour_Average(double latent_heat_net_flux_surface_2_Hour_Average) {
        Latent_heat_net_flux_surface_2_Hour_Average = latent_heat_net_flux_surface_2_Hour_Average;
    }

    public double getMaximum_temperature_height_above_ground_2_Hour_Maximum() {
        return Maximum_temperature_height_above_ground_2_Hour_Maximum;
    }

    public void setMaximum_temperature_height_above_ground_2_Hour_Maximum(double maximum_temperature_height_above_ground_2_Hour_Maximum) {
        Maximum_temperature_height_above_ground_2_Hour_Maximum = maximum_temperature_height_above_ground_2_Hour_Maximum;
    }

    public double getMinimum_temperature_height_above_ground_2_Hour_Minimum() {
        return Minimum_temperature_height_above_ground_2_Hour_Minimum;
    }

    public void setMinimum_temperature_height_above_ground_2_Hour_Minimum(double minimum_temperature_height_above_ground_2_Hour_Minimum) {
        Minimum_temperature_height_above_ground_2_Hour_Minimum = minimum_temperature_height_above_ground_2_Hour_Minimum;
    }

    public double getMomentum_flux_ucomponent_surface_2_Hour_Average() {
        return Momentum_flux_ucomponent_surface_2_Hour_Average;
    }

    public void setMomentum_flux_ucomponent_surface_2_Hour_Average(double momentum_flux_ucomponent_surface_2_Hour_Average) {
        Momentum_flux_ucomponent_surface_2_Hour_Average = momentum_flux_ucomponent_surface_2_Hour_Average;
    }

    public double getMomentum_flux_vcomponent_surface_2_Hour_Average() {
        return Momentum_flux_vcomponent_surface_2_Hour_Average;
    }

    public void setMomentum_flux_vcomponent_surface_2_Hour_Average(double momentum_flux_vcomponent_surface_2_Hour_Average) {
        Momentum_flux_vcomponent_surface_2_Hour_Average = momentum_flux_vcomponent_surface_2_Hour_Average;
    }

    public double getPer_cent_frozen_precipitation_surface() {
        return Per_cent_frozen_precipitation_surface;
    }

    public void setPer_cent_frozen_precipitation_surface(double per_cent_frozen_precipitation_surface) {
        Per_cent_frozen_precipitation_surface = per_cent_frozen_precipitation_surface;
    }

    public double getPrecipitable_water_entire_atmosphere_single_layer() {
        return Precipitable_water_entire_atmosphere_single_layer;
    }

    public void setPrecipitable_water_entire_atmosphere_single_layer(double precipitable_water_entire_atmosphere_single_layer) {
        Precipitable_water_entire_atmosphere_single_layer = precipitable_water_entire_atmosphere_single_layer;
    }

    public double getPrecipitation_rate_surface_2_Hour_Average() {
        return Precipitation_rate_surface_2_Hour_Average;
    }

    public void setPrecipitation_rate_surface_2_Hour_Average(double precipitation_rate_surface_2_Hour_Average) {
        Precipitation_rate_surface_2_Hour_Average = precipitation_rate_surface_2_Hour_Average;
    }

    public double getPressure_maximum_wind() {
        return Pressure_maximum_wind;
    }

    public void setPressure_maximum_wind(double pressure_maximum_wind) {
        Pressure_maximum_wind = pressure_maximum_wind;
    }

    public double getPressure_surface() {
        return Pressure_surface;
    }

    public void setPressure_surface(double pressure_surface) {
        Pressure_surface = pressure_surface;
    }

    @Override
    public double getRelative_humidity_height_above_ground() {
        return Relative_humidity_height_above_ground;
    }

    @Override
    public void setRelative_humidity_height_above_ground(double relative_humidity_height_above_ground) {
        Relative_humidity_height_above_ground = relative_humidity_height_above_ground;
    }

    public double getRelative_humidity_entire_atmosphere_single_layer() {
        return Relative_humidity_entire_atmosphere_single_layer;
    }

    public void setRelative_humidity_entire_atmosphere_single_layer(double relative_humidity_entire_atmosphere_single_layer) {
        Relative_humidity_entire_atmosphere_single_layer = relative_humidity_entire_atmosphere_single_layer;
    }

    public double getSensible_heat_net_flux_surface_2_Hour_Average() {
        return Sensible_heat_net_flux_surface_2_Hour_Average;
    }

    public void setSensible_heat_net_flux_surface_2_Hour_Average(double sensible_heat_net_flux_surface_2_Hour_Average) {
        Sensible_heat_net_flux_surface_2_Hour_Average = sensible_heat_net_flux_surface_2_Hour_Average;
    }

    public double getSnow_depth_surface() {
        return Snow_depth_surface;
    }

    public void setSnow_depth_surface(double snow_depth_surface) {
        Snow_depth_surface = snow_depth_surface;
    }

    public double getSpecific_humidity_height_above_ground() {
        return Specific_humidity_height_above_ground;
    }

    public void setSpecific_humidity_height_above_ground(double specific_humidity_height_above_ground) {
        Specific_humidity_height_above_ground = specific_humidity_height_above_ground;
    }

    public double getTemperature_maximum_wind() {
        return Temperature_maximum_wind;
    }

    public void setTemperature_maximum_wind(double temperature_maximum_wind) {
        Temperature_maximum_wind = temperature_maximum_wind;
    }

    @Override
    public double getTemperature_height_above_ground() {
        return Temperature_height_above_ground;
    }

    @Override
    public void setTemperature_height_above_ground(double temperature_height_above_ground) {
        Temperature_height_above_ground = temperature_height_above_ground;
    }

    @Override
    public double getTemperature_surface() {
        return Temperature_surface;
    }

    @Override
    public void setTemperature_surface(double temperature_surface) {
        Temperature_surface = temperature_surface;
    }

    public double getTotal_cloud_cover_entire_atmosphere_2_Hour_Average() {
        return Total_cloud_cover_entire_atmosphere_2_Hour_Average;
    }

    public void setTotal_cloud_cover_entire_atmosphere_2_Hour_Average(double total_cloud_cover_entire_atmosphere_2_Hour_Average) {
        Total_cloud_cover_entire_atmosphere_2_Hour_Average = total_cloud_cover_entire_atmosphere_2_Hour_Average;
    }

    public double getTotal_ozone_entire_atmosphere_single_layer() {
        return Total_ozone_entire_atmosphere_single_layer;
    }

    public void setTotal_ozone_entire_atmosphere_single_layer(double total_ozone_entire_atmosphere_single_layer) {
        Total_ozone_entire_atmosphere_single_layer = total_ozone_entire_atmosphere_single_layer;
    }

    public double getTotal_precipitation_surface_2_Hour_Accumulation() {
        return Total_precipitation_surface_2_Hour_Accumulation;
    }

    public void setTotal_precipitation_surface_2_Hour_Accumulation(double total_precipitation_surface_2_Hour_Accumulation) {
        Total_precipitation_surface_2_Hour_Accumulation = total_precipitation_surface_2_Hour_Accumulation;
    }

    public double getCategorical_Rain_surface_2_Hour_Average() {
        return Categorical_Rain_surface_2_Hour_Average;
    }

    public void setCategorical_Rain_surface_2_Hour_Average(double categorical_Rain_surface_2_Hour_Average) {
        Categorical_Rain_surface_2_Hour_Average = categorical_Rain_surface_2_Hour_Average;
    }

    public double getCategorical_Freezing_Rain_surface_2_Hour_Average() {
        return Categorical_Freezing_Rain_surface_2_Hour_Average;
    }

    public void setCategorical_Freezing_Rain_surface_2_Hour_Average(double categorical_Freezing_Rain_surface_2_Hour_Average) {
        Categorical_Freezing_Rain_surface_2_Hour_Average = categorical_Freezing_Rain_surface_2_Hour_Average;
    }

    public double getCategorical_Ice_Pellets_surface_2_Hour_Average() {
        return Categorical_Ice_Pellets_surface_2_Hour_Average;
    }

    public void setCategorical_Ice_Pellets_surface_2_Hour_Average(double categorical_Ice_Pellets_surface_2_Hour_Average) {
        Categorical_Ice_Pellets_surface_2_Hour_Average = categorical_Ice_Pellets_surface_2_Hour_Average;
    }

    public double getCategorical_Snow_surface_2_Hour_Average() {
        return Categorical_Snow_surface_2_Hour_Average;
    }

    public void setCategorical_Snow_surface_2_Hour_Average(double categorical_Snow_surface_2_Hour_Average) {
        Categorical_Snow_surface_2_Hour_Average = categorical_Snow_surface_2_Hour_Average;
    }

    public double getConvective_Precipitation_Rate_surface_2_Hour_Average() {
        return Convective_Precipitation_Rate_surface_2_Hour_Average;
    }

    public void setConvective_Precipitation_Rate_surface_2_Hour_Average(double convective_Precipitation_Rate_surface_2_Hour_Average) {
        Convective_Precipitation_Rate_surface_2_Hour_Average = convective_Precipitation_Rate_surface_2_Hour_Average;
    }

    public double getPotential_Evaporation_Rate_surface() {
        return Potential_Evaporation_Rate_surface;
    }

    public void setPotential_Evaporation_Rate_surface(double potential_Evaporation_Rate_surface) {
        Potential_Evaporation_Rate_surface = potential_Evaporation_Rate_surface;
    }

    public double getZonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average() {
        return Zonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average;
    }

    public void setZonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average(double zonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average) {
        Zonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average = zonal_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average;
    }

    public double getMeridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average() {
        return Meridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average;
    }

    public void setMeridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average(double meridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average) {
        Meridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average = meridional_Flux_of_Gravity_Wave_Stress_surface_2_Hour_Average;
    }

    public double getPlanetary_Boundary_Layer_Height_surface() {
        return Planetary_Boundary_Layer_Height_surface;
    }

    public void setPlanetary_Boundary_Layer_Height_surface(double planetary_Boundary_Layer_Height_surface) {
        Planetary_Boundary_Layer_Height_surface = planetary_Boundary_Layer_Height_surface;
    }

    public double getDownward_ShortWave_Radiation_Flux_surface_2_Hour_Average() {
        return Downward_ShortWave_Radiation_Flux_surface_2_Hour_Average;
    }

    public void setDownward_ShortWave_Radiation_Flux_surface_2_Hour_Average(double downward_ShortWave_Radiation_Flux_surface_2_Hour_Average) {
        Downward_ShortWave_Radiation_Flux_surface_2_Hour_Average = downward_ShortWave_Radiation_Flux_surface_2_Hour_Average;
    }

    public double getUpward_ShortWave_Radiation_Flux_surface_2_Hour_Average() {
        return Upward_ShortWave_Radiation_Flux_surface_2_Hour_Average;
    }

    public void setUpward_ShortWave_Radiation_Flux_surface_2_Hour_Average(double upward_ShortWave_Radiation_Flux_surface_2_Hour_Average) {
        Upward_ShortWave_Radiation_Flux_surface_2_Hour_Average = upward_ShortWave_Radiation_Flux_surface_2_Hour_Average;
    }

    public double getDownward_LongWave_Radp_Flux_surface_2_Hour_Average() {
        return Downward_LongWave_Radp_Flux_surface_2_Hour_Average;
    }

    public void setDownward_LongWave_Radp_Flux_surface_2_Hour_Average(double downward_LongWave_Radp_Flux_surface_2_Hour_Average) {
        Downward_LongWave_Radp_Flux_surface_2_Hour_Average = downward_LongWave_Radp_Flux_surface_2_Hour_Average;
    }

    public double getUpward_LongWave_Radp_Flux_surface_2_Hour_Average() {
        return Upward_LongWave_Radp_Flux_surface_2_Hour_Average;
    }

    public void setUpward_LongWave_Radp_Flux_surface_2_Hour_Average(double upward_LongWave_Radp_Flux_surface_2_Hour_Average) {
        Upward_LongWave_Radp_Flux_surface_2_Hour_Average = upward_LongWave_Radp_Flux_surface_2_Hour_Average;
    }

    public double getCloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average() {
        return Cloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average;
    }

    public void setCloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average(double cloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average) {
        Cloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average = cloud_Work_Function_entire_atmosphere_single_layer_2_Hour_Average;
    }

    public double getSunshine_Duration_surface() {
        return Sunshine_Duration_surface;
    }

    public void setSunshine_Duration_surface(double sunshine_Duration_surface) {
        Sunshine_Duration_surface = sunshine_Duration_surface;
    }

    public double getSurface_Lifted_Index_surface() {
        return Surface_Lifted_Index_surface;
    }

    public void setSurface_Lifted_Index_surface(double surface_Lifted_Index_surface) {
        Surface_Lifted_Index_surface = surface_Lifted_Index_surface;
    }

    public double getBest_4_layer_Lifted_Index_surface() {
        return Best_4_layer_Lifted_Index_surface;
    }

    public void setBest_4_layer_Lifted_Index_surface(double best_4_layer_Lifted_Index_surface) {
        Best_4_layer_Lifted_Index_surface = best_4_layer_Lifted_Index_surface;
    }

    public double getGround_Heat_Flux_surface_2_Hour_Average() {
        return Ground_Heat_Flux_surface_2_Hour_Average;
    }

    public void setGround_Heat_Flux_surface_2_Hour_Average(double ground_Heat_Flux_surface_2_Hour_Average) {
        Ground_Heat_Flux_surface_2_Hour_Average = ground_Heat_Flux_surface_2_Hour_Average;
    }

    public double getWilting_Point_surface() {
        return Wilting_Point_surface;
    }

    public void setWilting_Point_surface(double wilting_Point_surface) {
        Wilting_Point_surface = wilting_Point_surface;
    }

    public double getLandsea_coverage_nearest_neighbor_land1sea0_surface() {
        return Landsea_coverage_nearest_neighbor_land1sea0_surface;
    }

    public void setLandsea_coverage_nearest_neighbor_land1sea0_surface(double landsea_coverage_nearest_neighbor_land1sea0_surface) {
        Landsea_coverage_nearest_neighbor_land1sea0_surface = landsea_coverage_nearest_neighbor_land1sea0_surface;
    }

    public double getField_Capacity_surface() {
        return Field_Capacity_surface;
    }

    public void setField_Capacity_surface(double field_Capacity_surface) {
        Field_Capacity_surface = field_Capacity_surface;
    }

    public double getVisibility_surface() {
        return Visibility_surface;
    }

    public void setVisibility_surface(double visibility_surface) {
        Visibility_surface = visibility_surface;
    }

    public double getWater_equivalent_of_accumulated_snow_depth_surface() {
        return Water_equivalent_of_accumulated_snow_depth_surface;
    }

    public void setWater_equivalent_of_accumulated_snow_depth_surface(double water_equivalent_of_accumulated_snow_depth_surface) {
        Water_equivalent_of_accumulated_snow_depth_surface = water_equivalent_of_accumulated_snow_depth_surface;
    }

    public double getWater_runoff_surface_2_Hour_Accumulation() {
        return Water_runoff_surface_2_Hour_Accumulation;
    }

    public void setWater_runoff_surface_2_Hour_Accumulation(double water_runoff_surface_2_Hour_Accumulation) {
        Water_runoff_surface_2_Hour_Accumulation = water_runoff_surface_2_Hour_Accumulation;
    }

    public double getWind_speed_gust_surface() {
        return Wind_speed_gust_surface;
    }

    public void setWind_speed_gust_surface(double wind_speed_gust_surface) {
        Wind_speed_gust_surface = wind_speed_gust_surface;
    }

    public double getUcomponent_of_wind_maximum_wind() {
        return ucomponent_of_wind_maximum_wind;
    }

    public void setUcomponent_of_wind_maximum_wind(double ucomponent_of_wind_maximum_wind) {
        this.ucomponent_of_wind_maximum_wind = ucomponent_of_wind_maximum_wind;
    }

    @Override
    public double getUcomponent_of_wind_height_above_ground() {
        return ucomponent_of_wind_height_above_ground;
    }

    @Override
    public void setUcomponent_of_wind_height_above_ground(double ucomponent_of_wind_height_above_ground) {
        this.ucomponent_of_wind_height_above_ground = ucomponent_of_wind_height_above_ground;
    }

    public double getVcomponent_of_wind_maximum_wind() {
        return vcomponent_of_wind_maximum_wind;
    }

    public void setVcomponent_of_wind_maximum_wind(double vcomponent_of_wind_maximum_wind) {
        this.vcomponent_of_wind_maximum_wind = vcomponent_of_wind_maximum_wind;
    }

    @Override
    public double getVcomponent_of_wind_height_above_ground() {
        return vcomponent_of_wind_height_above_ground;
    }

    @Override
    public void setVcomponent_of_wind_height_above_ground(double vcomponent_of_wind_height_above_ground) {
        this.vcomponent_of_wind_height_above_ground = vcomponent_of_wind_height_above_ground;
    }
}
