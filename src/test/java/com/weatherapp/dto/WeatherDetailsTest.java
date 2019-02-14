package com.weatherapp.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class WeatherDetailsTest {
	
	@InjectMocks
	WeatherDetails weatherDetails;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSetTemp() {
		weatherDetails.setTemp("8");
		assertEquals("8",weatherDetails.getTemp());
	}

	@Test
	public void testSetTempMin() {
		weatherDetails.setTempMin("2");
		assertEquals("2",weatherDetails.getTempMin());
	}

	@Test
	public void testSetHumidity() {
		weatherDetails.setHumidity("low");
		assertEquals("low",weatherDetails.getHumidity());
	}

	@Test
	public void testSetPressure() {
		weatherDetails.setPressure("33");
		assertEquals("33",weatherDetails.getPressure());
	}

	@Test
	public void testSetTempMax() {
		weatherDetails.setTempMax("8");
		assertEquals("8",weatherDetails.getTempMax());
	}

}
