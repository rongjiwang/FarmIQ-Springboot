package com.farmiq.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

    private final BeerRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BeerCommandLineRunner(BeerRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        final String query = "select * from [dbo].[beer]";
        //final String query = "select * from [farmiq-pr12.0].[dbo].[Country]";

        /*List<Beer> beers = jdbcTemplate.query(query, new RowMapper<Beer>() {
            @Override
            public Beer mapRow(ResultSet resultSet, int i) throws SQLException {
                Beer beer = new Beer();
                beer.setId(resultSet.getLong("id"));
                beer.setName(resultSet.getString("name"));
                repository.save(beer);
                return beer;
            }
        });*/

        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy").forEach(name -> repository.save(new Beer(name)));

        repository.findAll().forEach(System.out::println);
    }
}
