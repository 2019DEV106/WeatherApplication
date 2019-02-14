package com.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData
{
    private String dt;

    @JsonProperty("coord")
    private CoordinatesDetails coordinatesDetails;

    private String visibility;

    private Weather[] weather;

    private String name;

    private String cod;
    
    @JsonProperty("main")
    private WeatherDetails weatherDetails;
    
    @JsonProperty("clouds")
	private CloudDetails cloudType;

    private String id;
    
    @JsonProperty("sys")
    private WeatherType weatherType;

    private String base;
    
    @JsonProperty("wind")
    private WindDetails windDetails;

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public CoordinatesDetails getCoordinatesDetails() {
		return coordinatesDetails;
	}

	public void setCoordinatesDetails(CoordinatesDetails coordinatesDetails) {
		this.coordinatesDetails = coordinatesDetails;
	}

	public String getCod ()
    {
        return cod;
    }

	public void setCod (String cod)
    {
        this.cod = cod;
    }

    public WindDetails getWindDetails() {
		return windDetails;
	}

	public void setWindDetails(WindDetails windDetails) {
		this.windDetails = windDetails;
	}

	public CloudDetails getCloudType() {
		return cloudType;
	}

	public void setCloudType(CloudDetails cloudType) {
		this.cloudType = cloudType;
	}

	public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    

    public WeatherDetails getWeatherDetails() {
		return weatherDetails;
	}

	public void setWeatherDetails(WeatherDetails weatherDetails) {
		this.weatherDetails = weatherDetails;
	}

	public WeatherType getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(WeatherType weatherType) {
		this.weatherType = weatherType;
	}
   
}
		