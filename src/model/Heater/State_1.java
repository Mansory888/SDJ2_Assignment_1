package model.Heater;

public class State_1 implements HeaterState{
    @Override public void clickUP(Heater heater){
        heater.setState(new State_2());
    }

    @Override public void clickDown(Heater heater) {heater.setState(new State_0());}

    @Override public int alert(){
        return 1;
    }
}
