package com.weatherapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WeatherAppController {
	 
	
	@GetMapping(value="/weatherReport")
	public String weatherReport()  {

		return "weatherInfo";
	}   
	
	
	@PostMapping(value="/weatherReport")
	public String prepareWeatherReport(ModelMap model,@RequestParam String latitude , @RequestParam String longitude){
		  
		return "weatherDetails";
	}

 
	 
	 
}
