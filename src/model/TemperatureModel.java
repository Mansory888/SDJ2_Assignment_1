package model;

import model.Heater.Heater;
import utility.UnnamedPropertySubject;


public interface TemperatureModel extends UnnamedPropertySubject {
    void addTemperature(String id, double temperature);

    Temperature getLastInsertedTemperature();

    int getHeaterPower();

    public double getOutsideTemperature();

    void clickUp();

    void clickDown();

    Temperature getLastInsertedTemperature(String id);
}
