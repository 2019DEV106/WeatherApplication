package com.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapp.customexception.WeatherException;
import com.weatherapp.service.WeatherAppServiceImpl;


@Controller
public class WeatherAppController {

	@Autowired
	public WeatherAppServiceImpl weatherAppServiceImpl;

	@GetMapping(value = "/weatherReport")
	public String weatherReport() {

		return "weatherInfo";
	}

	@PostMapping(value = "/weatherReport")
	public String prepareWeatherReport(ModelMap model, @RequestParam String latitude, @RequestParam String longitude) {
		String latitudeAndlongitude = "lat=" + latitude + "&lon=" + longitude;
		try {
			model.put("weatherData", weatherAppServiceImpl.fetchweatherInfo(latitudeAndlongitude));
			return "weatherDetails";
		} catch (WeatherException e) {
			return "errorPage";
		}
	}

}
