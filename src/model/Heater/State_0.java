package model.Heater;

public class State_0 implements HeaterState{
    @Override public void clickUP(Heater heater){
        heater.setState(new State_1());
    }

    @Override public void clickDown(Heater heater){

    }

    @Override public int alert(){
        return 0;
    }

}
