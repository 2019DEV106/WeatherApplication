package com.weatherapp.constants;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class WeatherAppConstantsTest {

	@Test
	public void testWeatherAppConstants() {
		WeatherAppConstants weatherAppConstants = new WeatherAppConstants();
		assertNotNull(weatherAppConstants);
	}
}
