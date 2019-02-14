package com.weatherapp.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(WeatherAppController.class)
public class WeatherAppControllerTest {

	 
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
	public void testWeatherReportReturnsMethodNotAllowedForPost() throws Exception{

		mockMvc.perform(post("/weatherReport")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isMethodNotAllowed());
	}
	
}
