package com.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoordinatesDetails
{
	@JsonProperty("lon")
    private String longitude;
	
    @JsonProperty("lat")
    private String latitude;

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

     
 
}