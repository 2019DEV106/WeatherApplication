package com.weatherapp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.constants.WeatherAppConstants;
import com.weatherapp.customexception.WeatherException;
import com.weatherapp.dto.WeatherData;

@Service
public class WeatherAppServiceImpl implements WeatherAppService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public WeatherData fetchweatherInfo(String latitudeAndlongitude) throws WeatherException {

		String uri = WeatherAppConstants.WHEATHER_API_URI + latitudeAndlongitude;
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		try {
			return mapper.readValue(response.getBody(), WeatherData.class);
		} catch (JsonMappingException e) {
			throw new WeatherException("Exception during Json Mapping ", e);
		} catch (JsonParseException e) {
			throw new WeatherException("Exception during Json Parsing ", e);
		} catch (IOException e) {
			throw new WeatherException("IOException during API call ", e);
		}
	}

}
