package com.farmiq.farmDetails;


import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import mil.nga.wkb.util.GeometryJSONCompatible;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.wololo.geojson.GeoJSON;
import org.wololo.jts2geojson.GeoJSONReader;
import org.wololo.jts2geojson.GeoJSONWriter;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Component
public class FarmDetailCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(FarmDetailCommandLineRunner.class);

    private final FarmDetailRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public FarmDetailCommandLineRunner(FarmDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        //final String query = "select area, geometry.STAsText() geoText, name, regionId from [dbo].[v_farmDetails] f inner join [dbo].[Dimensions] d on (f.dimensionsId = d.id) where f.id=152";
        //final String query = "select * from [dbo].[Dimensions]";
        final String query = "select *, geometry.STAsText() geoText from [v_NutrientApplicationsSummary] where farmId = 152";

        List<FarmDetail> farmDetails = jdbcTemplate.query(query, new RowMapper<FarmDetail>() {
            @Override
            public FarmDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                FarmDetail farmDetail = new FarmDetail();

                /*ResultSetMetaData rs = resultSet.getMetaData();
                int columnCount = rs.getColumnCount();
                for (int x = 1; x <= columnCount; x++) {
                    String s = rs.getColumnTypeName(x);
                    String d = rs.getColumnLabel(x);
                }*/
/*
                farmDetail.setArea(resultSet.getDouble("area"));
                farmDetail.setName(resultSet.getString("name"));
                farmDetail.setRegionId(resultSet.getLong("regionId"));*/

                //load data from database
                farmDetail.setUnitsHa(resultSet.getDouble("unitsHa"));
                farmDetail.setCalciumValue(resultSet.getDouble("Calcium_Value"));
                farmDetail.setCalciumPerHa(resultSet.getDouble("Calcium_perHa"));
                farmDetail.setSulfurValue(resultSet.getDouble("Sulfur_Value"));
                farmDetail.setSulfurPerHa(resultSet.getDouble("Sulfur_perHa"));
                farmDetail.setNitrogenValue(resultSet.getDouble("Nitrogen_Value"));
                farmDetail.setNitrogenPerHa(resultSet.getDouble("Nitrogen_perHa"));
                farmDetail.setPhosphorusValue(resultSet.getDouble("Phosphorus_Value"));
                farmDetail.setPhosphorusPerHa(resultSet.getDouble("Phosphorus_perHa"));
                farmDetail.setPotassiumValue(resultSet.getDouble("Potassium_Value"));
                farmDetail.setPotassiumPerHa(resultSet.getDouble("Potassium_perHa"));


                String geoEncodeDatabaseType = resultSet.getString("geoText");

                WKTReader wktReader = new WKTReader();
                try {
                    Geometry geoObj = wktReader.read(geoEncodeDatabaseType);
                    GeoJSONWriter writer = new GeoJSONWriter();
                    GeoJSON geoDecodeJsonType = writer.write(geoObj);
                    String geoJsonString = geoDecodeJsonType.toString();
                    farmDetail.setGeometry(geoJsonString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                repository.save(farmDetail);
                return farmDetail;
            }
        });
    }
}
