package com.weatherapp.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class WeatherTypeTest {
 
	@InjectMocks
	private WeatherType weatherType;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSetCountry() {
		weatherType.setCountry("Brussels");
		assertEquals("Brussels",weatherType.getCountry());
	}

	@Test
	public void testSetSunrise() {
		weatherType.setSunrise("1549782221");
		assertEquals("1549782221",weatherType.getSunrise());
	}

	@Test
	public void testSetSunset() {
		weatherType.setSunset("15497823423");
		assertEquals("15497823423",weatherType.getSunset());
	}

	@Test
	public void testSetId() {
		weatherType.setId("234");
		assertEquals("234",weatherType.getId());
	}

	@Test
	public void testSetType() {
		weatherType.setType("cloudy");
		assertEquals("cloudy",weatherType.getType());
	}

	@Test
	public void testSetMessage() {
		weatherType.setMessage("Sunny");
		assertEquals("Sunny",weatherType.getMessage());
	}

}
