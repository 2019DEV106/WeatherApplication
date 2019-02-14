package com.weatherapp.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.weatherapp.constants.WeatherAppConstants;
import com.weatherapp.dto.WeatherData;

public class WeatherAppServiceImplTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private WeatherAppServiceImpl weatherAppService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testfetchweatherInfoReturnNullResponse() throws Exception {
		when(restTemplate.getForEntity(WeatherAppConstants.WHEATHER_API_URI+"lat=50.8503&lon=4.3517", String.class))
		.thenReturn(null);
		WeatherData weatherData = weatherAppService.fetchweatherInfo("lat=50.8503&lon=4.3517");
		assertNull(weatherData);
	}
	 
}
