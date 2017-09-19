package com.farmiq.farmDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class FarmDetailCommandLineRunner implements CommandLineRunner {

    private final FarmDetailRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FarmDetailCommandLineRunner(FarmDetailRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        final String query = "select * from [dbo].[v_farmDetails] f inner join [dbo].[Dimensions] d on (f.dimensionsId = d.id) where f.id=152";
        List<FarmDetail> farmDetails = jdbcTemplate.query(query, new RowMapper<FarmDetail>(){

            @Override
            public FarmDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                FarmDetail farmDetail = new FarmDetail();
                farmDetail.setId(resultSet.getLong("id"));
                farmDetail.setName(resultSet.getString("name"));
                repository.save(farmDetail);
                return farmDetail;
            }
        });
    }
}
