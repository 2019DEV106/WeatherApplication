package com.weatherapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;

import com.weatherapp.customexception.WeatherException;
import com.weatherapp.dto.WeatherData;
import com.weatherapp.service.WeatherAppServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(WeatherAppController.class)
public class WeatherAppControllerTest {

	@MockBean
	public WeatherAppServiceImpl weatherAppServiceImpl;

	@Mock
	public WeatherAppServiceImpl weatherAppServiceImplMock;
	
	 
	@InjectMocks
	private WeatherAppController weatherAppController;
	
	
	@Autowired
	MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(weatherAppController);
	}
	@Test
	public void testWeatherReportReturnNotFoundForInvalidURL() throws Exception{
		mockMvc.perform(get("/home")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	 
	@Test
	public void testWeatherReportReturnSuccessForValidURL() throws Exception{

		mockMvc.perform(get("/weatherReport")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	  
	@Test
	public void testWeatherReportReturnNotNullResponse() throws Exception{
		String result = weatherAppController.weatherReport();
		assertEquals("weatherInfo", result);
	}

	@Test
	public void testWeatherReportReturnsBadRequestForPost() throws Exception{

		mockMvc.perform(post("/weatherReport")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testPrepareWeatherReportReturnsNotFoundForInvalidURL() throws Exception{
		mockMvc.perform(post("/weatherReports")
				.param("latitude", "12350.8503").param("longitude", "4.3517")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	 
	
	@Test
	public void testPrepareWeatherReportReturnsValidResponse() throws Exception{

		mockMvc.perform(post("/weatherReport").param("latitude", "12350.8503").param("longitude", "4.3517")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testWeatherReportWeatherException() throws Exception{
		when(weatherAppServiceImplMock.fetchweatherInfo(anyString())).thenThrow(new WeatherException("exception"));
		ModelMap modelMap = new ModelMap();
		String result = weatherAppController.prepareWeatherReport(modelMap, "latitude", "12350.8503");
		assertEquals("errorPage", result);
		assertNull(modelMap.get("weatherData"));
		verify(weatherAppServiceImplMock, times(1)).fetchweatherInfo(anyString());
	}
	
	@Test
	public void testWeatherReportReturnNullResponse() throws Exception{
		when(weatherAppServiceImplMock.fetchweatherInfo("lat=50.8503&lon=4.3517")).thenReturn(null);
		ModelMap modelMap = new ModelMap();
		String result = weatherAppController.prepareWeatherReport(modelMap, "latitude", "12350.8503");
		assertEquals("weatherDetails", result);
		assertNull(modelMap.get("weatherData"));
		verify(weatherAppServiceImplMock, times(1)).fetchweatherInfo(anyString());
	}
	
	@Test
	public void testWeatherReportReturnSuccessResponse() throws Exception{
		WeatherData weatherData = new WeatherData();
		weatherData.setName("Brussels");
		when(weatherAppServiceImplMock.fetchweatherInfo(anyString())).thenReturn(weatherData);

		ModelMap modelMap = new ModelMap();
		String result = weatherAppController.prepareWeatherReport(modelMap, "latitude", "12350.8503");
		assertEquals("weatherDetails", result);
		assertNotNull(modelMap.get("weatherData"));
		assertEquals("Brussels", weatherData.getName());
		verify(weatherAppServiceImplMock, times(1)).fetchweatherInfo(anyString());
	}

}
