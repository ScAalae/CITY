package app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.dao.CityDao;
import app.pojo.City;


@Controller
public class CrudController {
	
	@Autowired
	private CityDao cityDao;
	//////////////////////READ///////////////////////////////////////////////////////////
	@RequestMapping(value = "/read")
	public ModelAndView readCity(ModelAndView model) throws IOException {

	List<City> listCity = cityDao.read();
	model.addObject("listCity", listCity);
	model.setViewName("read");

	return model;
	}
	
	
		//////////////////////////////CREATE/////////////////////////////////////////////////////
		@RequestMapping(value = "/create", method = RequestMethod.GET)
		public ModelAndView createCity(ModelAndView mv) {
		
			mv.setViewName("create");
			
			return mv;
		}
		
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public String createCity(@RequestParam("name") String name,
				@RequestParam("land") String land) {
		
			City city = new City();
			city.setName(name);
			city.setLand(land);
			
			cityDao.create(city);
			
		
			return "redirect:/read/";
		}

////////////////////////UPDATE///////////////////////////////////////////////////////////////
		@RequestMapping(value = "/update/{cityId}", method = RequestMethod.GET)
		public ModelAndView findCityById(ModelAndView model, @PathVariable("cityId") int cityId)
		throws IOException {
		
			List<City> listCity= cityDao.findCityById(cityId);
			model.addObject("listCity", listCity);
			model.setViewName("update");
			
			return model;
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String updateStudent(@RequestParam("id") int id, @RequestParam("name") String name,
		@RequestParam("land") String land,  ModelAndView mv) {
		
			City city = new City();
			city.setId(id);
			city.setName(name);
			city.setLand(land);
						
			cityDao.update(city);
			
			return "redirect:/read/";
		}

		
		///////////////////////////////////DELETE///////////////////////////////////////////////////////
		@RequestMapping(value = "/delete/{cityId}")
		public String deleteCityById(ModelAndView mv, @PathVariable("cityId") int cityId)
		throws IOException {
		
			cityDao.delete(cityId);
			
			return "redirect:/read/"; 
		}

}
