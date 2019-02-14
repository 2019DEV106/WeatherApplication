package com.weatherapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.constants.WeatherAppConstants;
import com.weatherapp.customexception.WeatherException;
import com.weatherapp.dto.WeatherData;

public class WeatherAppServiceImplTest {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private ObjectMapper objectMapper;
	
	@InjectMocks
	private WeatherAppServiceImpl weatherAppService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected=NullPointerException.class)
	public void testfetchweatherInfoReturnNullResponse() throws Exception {
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
		.thenReturn(null);
		WeatherData weatherData = weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		assertNull(weatherData);
	}
	 
	@Test(expected=WeatherException.class)
	public void testJsonMappingException() throws Exception {
		ResponseEntity<String> response = new ResponseEntity<String>("not a json", HttpStatus.OK);
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
				.thenReturn(response);
		when(objectMapper.readValue("not a json", WeatherData.class)).thenThrow((JsonMappingException.class));
		weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		verify(restTemplate, times(1)).getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class);
		verify(objectMapper, times(1)).readValue("not a json", WeatherData.class);

	}
	
	@Test(expected=WeatherException.class)
	public void testJsonParsingException() throws Exception {
		ResponseEntity<String> response = new ResponseEntity<String>("not a json", HttpStatus.OK);
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
				.thenReturn(response);
		when(objectMapper.readValue("not a json", WeatherData.class)).thenThrow((JsonParseException.class));
		weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		verify(restTemplate, times(1)).getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class);
		verify(objectMapper, times(1)).readValue("not a json", WeatherData.class);

	}
	
	@Test(expected=WeatherException.class)
	public void testIOExceptionduringJsonParsing() throws Exception {
		ResponseEntity<String> response = new ResponseEntity<String>("not a json", HttpStatus.OK);
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
				.thenReturn(response);
		when(objectMapper.readValue("not a json", WeatherData.class)).thenThrow((IOException.class));
		weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		verify(restTemplate, times(1)).getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class);
		verify(objectMapper, times(1)).readValue("not a json", WeatherData.class);
	}

	@Test(expected= RestClientException.class)
	public void testRestClientExceptionDuringAPICall() throws Exception {
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
				.thenThrow(RestClientException.class);

		weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		verify(restTemplate, times(1)).getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class);
		verifyZeroInteractions(objectMapper);

	}
	
	@Test
	public void testfetchweatherInfoReturnSuccessResponse() throws Exception {
		ResponseEntity<String> response = new ResponseEntity<String>("{\"name\":\"Brussels\"}", HttpStatus.OK);
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
		.thenReturn(response);
		WeatherData weatherDataTest = new WeatherData();
		weatherDataTest.setName("Brussels");
		when(objectMapper.readValue("{\"name\":\"Brussels\"}", WeatherData.class)).thenReturn(weatherDataTest);
		WeatherData weatherDataActual = weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		assertNotNull(weatherDataActual);
		assertEquals(weatherDataTest.getName(), weatherDataActual.getName());
		verify(restTemplate, times(1)).getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class);
		verify(objectMapper, times(1)).readValue("{\"name\":\"Brussels\"}", WeatherData.class);

	}



}
