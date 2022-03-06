package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import app.dao.CityDao;
import app.dao.CityDaoImpl;


	@Configuration
	@EnableWebMvc
	@ComponentScan("app")

	public class WebMvcConfig {
		@Bean
		InternalResourceViewResolver viewResolver() {

		    InternalResourceViewResolver vr = new InternalResourceViewResolver();

		    vr.setPrefix("/");
		    vr.setSuffix(".jsp");
		    return vr;
		}
		
		@Bean
		DriverManagerDataSource getDataSource() {
		    DriverManagerDataSource ds = new DriverManagerDataSource();
		    ds.setDriverClassName("org.postgresql.Driver");
		    ds.setUrl("jdbc:postgresql://localhost/city");
		    ds.setUsername("postgres");
		    ds.setPassword("postgres");
		   
		    return ds;
		}
		
		@Bean
		public CityDao getUserDao() {
		    return new CityDaoImpl(getDataSource());
		}
	}

