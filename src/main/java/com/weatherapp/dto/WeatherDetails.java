package com.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDetails
{
    private String temp;
    
    @JsonProperty("temp_min")
    private String tempMin;
    
    private String humidity;
     
    private String pressure;

    @JsonProperty("temp_max")
    private String tempMax;

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTempMin() {
		return tempMin;
	}

	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getTempMax() {
		return tempMax;
	}

	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}

     
}
			