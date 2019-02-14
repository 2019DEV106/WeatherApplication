package com.weatherapp.customexception;

public class WeatherException extends Exception {

	 
	private static final long serialVersionUID = 1L;

	public WeatherException(String message) {
		 super(message);
	}
	
	public WeatherException(String message, Exception exception) {
		
		 super(message,exception); 
	}

	
}
