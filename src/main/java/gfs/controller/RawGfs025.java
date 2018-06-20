package gfs.controller;

import gfs.dao.Dao;
import gfs.model.Gfs025;
import gfs.model.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ucar.ma2.Array;
import ucar.nc2.dt.GridCoordSystem;
import ucar.nc2.dt.GridDatatype;
import ucar.nc2.dt.grid.GridDataset;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RawGfs025 {

    private final static Logger logger = LoggerFactory.getLogger(RawGfs025.class);

    public void save(String file) throws ParseException {

        Dao dao = new Dao();
        List<Station> listStation = dao.getStationEnalbeApi();

        List<Gfs025> gfs025List = null;
        try {
            gfs025List = gribPlugin(listStation, file);
            logger.info(gfs025List.size() + " get Gfs list: " + file);
            dao.saveHourlyData(gfs025List, file);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            dao.close();
        }
    }

    public List<Gfs025> gribPlugin(List<Station> listStation, String gribFile) throws IOException {
        List<Gfs025> gfs025List = new ArrayList<Gfs025>();

        File file = new File(gribFile);
        if(file.exists()){
            GridDataset gds = GridDataset.open(gribFile);
            List<GridDatatype> types = gds.getGrids();

            for (Station station : listStation) {
                Gfs025 gfs025 = new Gfs025();

                GridDatatype grid = gds.findGridDatatype(types.get(0).getFullName());
                GridCoordSystem gcs = grid.getCoordinateSystem();
                int[] xy = gcs.findXYindexFromLatLon(station.getLat(), station.getLon(), null); // xy[0] = x, xy[1] = y

                for (GridDatatype type : types) {
                    String fullname = type.getFullName();
                    String unit = type.getUnitsString();
                    grid = gds.findGridDatatype(fullname);

                    Array data = grid.readDataSlice(0, 0, xy[1], xy[0]); // note order is t, z, y, x
                    double val = data.getDouble(0); // we know its a scalar

                    if (unit.equals("K")) {
                        val = val - 273.15;
                    }

                    gfs025.setObjectData(fullname, val);
                }

                gfs025.extractData();

                String stationCode = station.getStation_code();
                gfs025.setStationCode(stationCode);

                gfs025List.add(gfs025);

            }
        }else{
            logger.info("File not found: "+ gribFile);
        }



        return gfs025List;
    }


}
