package com.weatherapp.customexception;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WeatherExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWeatherExceptionString() {
		WeatherException weatherException = new WeatherException("test");
		assertEquals("test",weatherException.getMessage());
	}

	@Test
	public void testWeatherExceptionStringException() {
		WeatherException weatherException = new WeatherException("test", new Exception());
		assertEquals("test",weatherException.getMessage());
	}

}
