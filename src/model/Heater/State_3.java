package model.Heater;

public class State_3 implements HeaterState{

    public State_3(Heater heater){
        Thread t1 = new Thread(()-> {
            try {
                Thread.sleep(40000);
            } catch (InterruptedException e){
                //
            }
            heater.setState(new State_2());

        });
        t1.start();
    }

    @Override public void clickUP(Heater heater){
        //heater.setState(new State_0());
    }

    @Override public void clickDown(Heater heater){heater.setState(new State_2());}

    @Override public int alert(){
        return 3;
    }

}




