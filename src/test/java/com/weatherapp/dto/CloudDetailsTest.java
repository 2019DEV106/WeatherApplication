package com.weatherapp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CloudDetailsTest {

	@Test
	public void testSetAll() {
		CloudDetails cloudType = new CloudDetails();
		 cloudType.setAll("cloudy");
		 assertEquals("cloudy",cloudType.getAll());
	}

}
