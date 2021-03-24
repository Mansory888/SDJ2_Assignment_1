package model.Heater;

public interface HeaterState {
    public void clickUP(Heater heater);
    public void clickDown(Heater heater);
    public int alert();
}
