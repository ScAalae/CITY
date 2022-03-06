package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import app.pojo.City;


public class CityDaoImpl implements CityDao {
	private JdbcTemplate jdbcTemplate;

	public CityDaoImpl(DataSource dataSoruce) {
	    jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public int create(City city) {

	    String sql = "insert into city(name,land) values(?,?)";

	    try {

	        int counter = jdbcTemplate.update(sql,
	                new Object[] { city.getName(), city.getLand() });

	        return counter;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	@Override
	public List<City> read() {
	    List<City> cityList = jdbcTemplate.query("SELECT * FROM city", new RowMapper<City>() {

	        @Override
	        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
	            City city = new City();

	            city.setId(rs.getInt("id"));
	            city.setName(rs.getString("name"));
	            city.setLand(rs.getString("land"));

	            return city;
	        }

	    });

	    return cityList;
	}
	@Override
	public List<City> findCityById(int cityId) {

	    List<City> cityList = jdbcTemplate.query("SELECT * FROM city where id=?",
	            new Object[] { cityId }, new RowMapper<City>() {

	                @Override
	                public City mapRow(ResultSet rs, int rowNum) throws SQLException {//?? mapRow
	                	City city = new City();

	                    city.setId(rs.getInt("id"));
	                    city.setName(rs.getString("name"));
	                    city.setLand(rs.getString("land"));

	                    return city;
	                }

	            });

	    return cityList;
	}
	
	@Override
	public int update(City city) {
	    String sql = "update  city set name=?,land=? where id=?";

	    try {

	        int counter = jdbcTemplate.update(sql,
	                new Object[] { city.getName(), city.getLand(),  city.getId() });

	        return counter;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	@Override
	public int delete(int cityId) {
	    String sql = "delete from city where id=?";

	    try {

	        int counter = jdbcTemplate.update(sql, new Object[] { cityId });//????

	        return counter;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}		
}
	
