package model.Heater;

public class State_2 implements HeaterState{
    @Override public void clickUP(Heater heater){
        heater.setState(new State_3(heater));
    }

    @Override public void clickDown(Heater heater){
        heater.setState(new State_1());
    }

    @Override public int alert(){
        return 2;
    }
}
