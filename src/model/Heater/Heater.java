package model.Heater;

public class Heater {
    private HeaterState state;

    public Heater(){
        state = new State_0();
    }

    public void clickUp(){
        state.clickUP(this);
    }

    public void clickDown(){
        state.clickDown(this);
    }

    public int status(){return  state.alert();}

    public void setState(HeaterState state){
        this.state = state;
    }
}
