package com.book.headfirstdesignpatterns.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsConditionDisplay statisticsConditionDisplay = new StatisticsConditionDisplay(weatherData);
        ForecastConditionDisplay forecastConditionDisplay = new ForecastConditionDisplay(weatherData);
        currentConditionDisplay.display();
        statisticsConditionDisplay.display();
        forecastConditionDisplay.display();
        weatherData.setMeasurements(10,20,30);
        weatherData.setMeasurements(11,22,33);
        weatherData.setMeasurements(55,66,77);


    }
}
