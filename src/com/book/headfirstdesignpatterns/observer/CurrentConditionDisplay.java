package com.book.headfirstdesignpatterns.observer;

public class CurrentConditionDisplay implements DisplayElement,Observer{
    WeatherData weatherData;
    private float humidity;
    private  float temperature;
    private float pressure;

    public CurrentConditionDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current ::: Temprature : "+temperature+" Humidity : "+humidity+" Pressure : "+pressure);

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
