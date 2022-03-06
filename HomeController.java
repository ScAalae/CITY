package app.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import app.dao.CityDao;
import app.pojo.City;

@Controller
public class HomeController {

	////////////////////////HOME///////////////////////////////////////////////////////
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView model) throws IOException {

	    model.setViewName("home");

	    return model;
	}
	//////////////////////READ///////////////////////////////////////////////////////////
}
