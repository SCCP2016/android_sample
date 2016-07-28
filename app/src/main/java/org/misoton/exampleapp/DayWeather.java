package org.misoton.exampleapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayWeather {
    public int dt;
    public List<WeatherDetail> weather;
}
