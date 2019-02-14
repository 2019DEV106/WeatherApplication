package com.weatherapp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CoordinatesDetailsTest {
 
	@InjectMocks
	CoordinatesDetails coordinatesDetails;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSetLongitude() {
		
		coordinatesDetails.setLongitude("0.95");
		assertEquals("0.95",coordinatesDetails.getLongitude());
	}

	@Test
	public void testSetLatitude() {
		coordinatesDetails.setLatitude("0.445");
		assertEquals("0.445",coordinatesDetails.getLatitude());
	}
  
}
