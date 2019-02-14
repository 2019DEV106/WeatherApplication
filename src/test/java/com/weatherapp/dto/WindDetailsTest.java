package com.weatherapp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class WindDetailsTest {


	@InjectMocks
	private WindDetails wind;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSetDeg() {
		wind.setDeg("260");
		assertEquals("260",wind.getDeg());
	}

	@Test
	public void testSetSpeed() {
		wind.setSpeed("260");
		assertEquals("260",wind.getSpeed());
	}
	
	@Test
	public void testSetGust() {
		wind.setGust("18.05");
		assertEquals("18.05",wind.getGust());
	}

}
