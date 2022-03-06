package app.dao;

import java.util.List;

import app.pojo.City;

public interface CityDao {
	int create(City city);
	
 	List<City> read();

 List<City> findCityById(int cityId);

 int update(City city);

int delete(int cityId);	
		
}
