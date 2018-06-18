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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RawGfs025 {


    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(RawGfs025.class);

        String testfile = "data/forecastSMS/file/gfs.2018061418/9";
        try {
            new RawGfs025().gribPlugin(testfile);
        } catch (IOException e) {
            logger.error("", e);

        }
    }

    public List<Gfs025> gribPlugin(String gribFile) throws IOException {
        List<Gfs025> gfs025List = new ArrayList<Gfs025>();

        Dao dao = new Dao();
        List<Station> listStation = dao.getStationEnalbeApi();
        System.out.println("listStation.size() = " + listStation.size());

        Gfs025 gfs025 = new Gfs025();

        GridDataset gds = GridDataset.open(gribFile);
        List<GridDatatype> types = gds.getGrids();

        for (Station station : listStation) {

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

        return gfs025List;
    }


}
