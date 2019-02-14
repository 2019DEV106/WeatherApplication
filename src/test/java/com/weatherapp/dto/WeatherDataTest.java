package com.weatherapp.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class WeatherDataTest {

	@InjectMocks
	private WeatherData weatherData;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSetDt() {
		weatherData.setDt("1549806120");
		assertEquals("1549806120",weatherData.getDt());
	}

	@Test
	public void testSetDtIsNull() {
		weatherData.setDt(null);
		assertNull(weatherData.getDt());
	}

	@Test
	public void testSetVisibility() {
		weatherData.setVisibility("6000");
		assertEquals("6000",weatherData.getVisibility());
	}

	@Test
	public void testSetVisibilityIsNull() {
		weatherData.setVisibility(null);
		assertNull(weatherData.getVisibility());
	}

	@Test
	public void testSetName() {
		weatherData.setName("brussels");
		assertEquals("brussels",weatherData.getName());
	}

	@Test
	public void testSetNameIsNull() {
		weatherData.setName(null);
		assertNull(weatherData.getName());
	}

	@Test
	public void testSetCod() {
		weatherData.setCod("200");
		assertEquals("200",weatherData.getCod());
	}

	@Test
	public void testSetCodIsNull() {
		weatherData.setCod(null);
		assertNull(null,weatherData.getCod());
	}

	@Test
	public void testSetId() {
		weatherData.setId("2800865");
		assertEquals("2800865",weatherData.getId());
	}

	@Test
	public void testSetIdIsNull() {
		weatherData.setId(null);
		assertNull(weatherData.getId());
	}

	@Test
	public void testSetBase() {
		weatherData.setBase("stations");
		assertEquals("stations",weatherData.getBase());

	}

	@Test
	public void testSetBaseIsNull() {
		weatherData.setBase(null);
		assertNull(weatherData.getBase());
	}

	@Test
	public void testSetCoordinatesDetails() {
		CoordinatesDetails coordinatesDetails = new CoordinatesDetails();
		coordinatesDetails.setLatitude("0.242");
		weatherData.setCoordinatesDetails(coordinatesDetails);
		assertEquals("0.242",weatherData.getCoordinatesDetails().getLatitude());
	}

	@Test
	public void testSetWeatherDetails() {
		WeatherDetails weatherDetails = new WeatherDetails();
		weatherDetails.setTemp("8");
		assertEquals("8",weatherDetails.getTemp());
	}

	@Test
	public void testSetCloudType() {
		CloudDetails cloudDetails = new CloudDetails();
		cloudDetails.setAll("92");
		assertEquals("92",cloudDetails.getAll());
	}

	@Test
	public void testWeatherType() {
		WeatherType weatherType = new WeatherType();
		weatherType.setCountry("Belgium");
		assertEquals("Belgium",weatherType.getCountry());
	}

	@Test
	public void testSetWindDetails() {
		WindDetails windDetails = new WindDetails();
		windDetails.setSpeed("34");
		assertEquals("34",windDetails.getSpeed());
	}
	
	@Test
	public void testSetWindDetailsIsNotNull() {
		weatherData.setWindDetails(new WindDetails());
		assertNotNull(weatherData.getWindDetails());
	}
	@Test
	public void testSetCloudTypeIsNotNull() {
		weatherData.setCloudType(new CloudDetails());
		assertNotNull(weatherData.getCloudType());
	}
	@Test
	public void testSetWeatherTypeIsNotNull() {
		weatherData.setWeatherType(new WeatherType());
		assertNotNull(weatherData.getWeatherType());
	}
	@Test
	public void testSetWeatherDetailsIsNotNull() {
		weatherData.setWeatherDetails(new WeatherDetails());
		assertNotNull(weatherData.getWeatherDetails());
	}
	
	@Test
	public void testSetWeatherIsNotNull() {
		weatherData.setWeather(new Weather[5]);
		assertNotNull(weatherData.getWeather());
	}
	
	 
}
