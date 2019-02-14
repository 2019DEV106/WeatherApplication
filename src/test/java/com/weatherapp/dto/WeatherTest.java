package com.weatherapp.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class WeatherTest {

	@InjectMocks
	Weather weather;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSetIcon() {
		weather.setIcon("09d");
		assertEquals("09d",weather.getIcon());
	}

	@Test
	public void testSetDescription() {
		weather.setDescription("shower rain");
		assertEquals("shower rain",weather.getDescription());
	}

	@Test
	public void testSetMain() {
		weather.setMain("weather details");
		assertEquals("weather details",weather.getMain());
	}

	@Test
	public void testSetId() {
		weather.setId("023");
		assertEquals("023",weather.getId());
	}

}
