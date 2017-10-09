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



    public FarmDetailCommandLineRunner(FarmDetailRepository repository){
        this.repository = repository;
    }

//    @Override
//    public void run(String... strings) throws Exception {
//        System.out.println("**"+strings+"**");
//        String query = "select * from [dbo].[v_farmDetails] f inner join [dbo].[Dimensions] d on (f.dimensionsId = d.id) where f.id=152";
//    }

    @Override
    public void run(String... strings) throws Exception {
       final String query = "select area, geometry.STAsText() geometry, name, regionId from [dbo].[v_farmDetails] f inner join [dbo].[Dimensions] d on (f.dimensionsId = d.id) where f.id=152";
        //final String query = "select * from [dbo].[Dimensions]";
        System.out.println("hello world");

        List<FarmDetail> farmDetails = jdbcTemplate.query(query, new RowMapper<FarmDetail>(){
            @Override
            public FarmDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                FarmDetail farmDetail = new FarmDetail();

                ResultSetMetaData rs = resultSet.getMetaData();
                int columnCount = rs.getColumnCount();
                for (int x = 1; x <= columnCount; x++)  {
                    String s = rs.getColumnTypeName(x);
                    String d = rs.getColumnLabel(x);
                    System.out.println ("Column " + x + " is type " + s+"  "+d);
                }
                //EntityManager em = JPAUtil.createEntityManager();
                //em.getTransaction().begin();

                //farmDetail.setId(resultSet.getLong("id"));
                farmDetail.setArea(resultSet.getDouble("area"));
                String temp = resultSet.getString("geometry");
                System.out.println(temp);
                //Polygon poly = new Polygon(temp);
                //byte[] raw = resultSet.getBytes("geometry");
                //WKBReader kb = new WKBReader(raw);
                //System.out.println(raw.toString()+ " "+raw.length);
                WKTReader wktReader = new WKTReader();


                try {
                    Geometry geom = wktReader.read(temp);
                    //geom.setSRID(4326);
                    System.out.println(geom.getGeometryType()+" **"+geom.getArea());
                    //farmDetail.setGeometry((Polygon) geom);
                    Polygon pp = (Polygon)geom;
                    //farmDetail.setGeometry(wktReader.read("POINT(-105.069999694824 39.75)"));
                    GeoJSONWriter writer = new GeoJSONWriter();
                    GeoJSON json = writer.write(geom);
                    String jsonstring = json.toString();
                    System.out.println("**   "+jsonstring);

                    GeoJSONReader reader = new GeoJSONReader();
                    Geometry geometry = reader.read(json);
                    farmDetail.setGeometry(jsonstring);

                    System.out.println(pp.getArea()+" "+ Arrays.toString(pp.getCoordinates()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
               /* WKBReader reader = new WKBReader();


                Geometry gg = null;
                try {
                    gg = reader.read(raw);
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/
                //farmDetail.setGeometry(temp);
                //Point geo = new Point(-42.2322334333,171.33376358378);
                //System.out.println(geo.getX()+" "+geo.getY());
                //farmDetail.setGeometry(temp);
                farmDetail.setName(resultSet.getString("name"));

                farmDetail.setRegionId(resultSet.getLong("regionId"));
                System.out.println("would hello!!");
                //em.persist(farmDetail);
                //em.getTransaction().commit();
                //em.close();
                repository.save(farmDetail);
                System.out.println("would hello");

                return farmDetail;
            }
        });
    }
}
