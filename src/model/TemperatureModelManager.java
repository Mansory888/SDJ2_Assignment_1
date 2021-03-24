package model;

import javafx.beans.property.DoubleProperty;
import model.Heater.Heater;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DecimalFormat;

public class TemperatureModelManager implements TemperatureModel {
    private PropertyChangeSupport property;
    private TemperatureList temperatureList;
    private Heater heater;


    public TemperatureModelManager(){
        property = new PropertyChangeSupport(this);
        temperatureList = new TemperatureList();
        heater = new Heater();
    }

    @Override public synchronized void addTemperature(String id, double value){
        Temperature temperature = new Temperature(id, value);
        Temperature old = getLastInsertedTemperature(id);
        this.temperatureList.addTemperature(temperature);

        property.firePropertyChange(id,null,temperature.getValue());

        property.firePropertyChange("Log",null,temperature.getlog());


        if (old != null && old.getValue() != temperature.getValue())
        {
            System.out.println("--> new=" + temperature + " (old=" + old + ")");
        }
        else if (old == null)
        {
            System.out.println("--> new=" + temperature + " (old=" + old + ")");
        }




    }

    @Override public Temperature getLastInsertedTemperature(){
        return temperatureList.getLastTemperature(null);
    }

    @Override public int getHeaterPower(){
        return heater.status();
    }

    public  Temperature getLastInsertedTemperature(String id)
    {
        return temperatureList.getLastTemperature(id);
    }

    @Override public void clickUp(){
        heater.clickUp();
    }

    @Override public void clickDown(){
        heater.clickDown();
    }

    @Override public double getOutsideTemperature(){
       return Double.parseDouble(new DecimalFormat("##.###").format(Thermometer.externalTemperature(2,-20,20)));
    }

    @Override public void addListener(PropertyChangeListener listener){
        property.addPropertyChangeListener(listener);
    }

    @Override public void removeListener(PropertyChangeListener listener){
        property.removePropertyChangeListener(listener);
    }









}
