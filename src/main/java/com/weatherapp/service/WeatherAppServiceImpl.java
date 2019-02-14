package com.weatherapp.service;

import org.springframework.stereotype.Service;

import com.weatherapp.customexception.WeatherException;
import com.weatherapp.dto.WeatherData;

@Service
public class WeatherAppServiceImpl implements WeatherAppService {

	

	@Override
	public WeatherData fetchweatherInfo(String latitudeAndlongitude) throws WeatherException { 
		
		return null;
	}

}
