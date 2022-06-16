package com.book.headfirstdesignpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> observerList ;
    private float humidity;
    private  float temperature;
    private float pressure;

    public WeatherData(){
        observerList = new ArrayList<Observer>();

    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o :observerList){
            o.update(temperature,humidity,pressure);
        }
    }

    public  void measurementChanged(){
        System.out.println("-------------------------");
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementChanged();
    }
}
