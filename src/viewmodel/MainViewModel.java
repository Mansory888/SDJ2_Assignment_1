package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import model.Temperature;
import model.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainViewModel implements PropertyChangeListener {
    private TemperatureModel model;
    private DoubleProperty temp1;
    private DoubleProperty temp2;
    private DoubleProperty otTemp;
    private IntegerProperty heaterStatus;
    private StringProperty warningLabel;

    public MainViewModel(TemperatureModel model){
        model.addListener(this);
        this.model = model;
        this.temp1 = new SimpleDoubleProperty();
        this.temp2 = new SimpleDoubleProperty();
        this.otTemp = new SimpleDoubleProperty();
        this.heaterStatus = new SimpleIntegerProperty();
        this.warningLabel = new SimpleStringProperty();

    }

    public void clear(){
        temp1.set(model.getLastInsertedTemperature("t1").getValue());
        temp2.set(model.getLastInsertedTemperature("t2").getValue());
        otTemp.set(model.getOutsideTemperature());
        heaterStatus.set(model.getHeaterPower());
        warningLabel.set("");
    }

    public void clickUP(){
        model.clickUp();
        heaterStatus.setValue(model.getHeaterPower());
    }

    public void clickDown(){
        model.clickDown();
        heaterStatus.setValue(model.getHeaterPower());
    }

    public DoubleProperty getTemp1(){return temp1;}
    public DoubleProperty getTemp2(){return temp2;}
    public DoubleProperty getOtTemp(){return otTemp;}
    public IntegerProperty getHeaterStatus(){return heaterStatus;}
    public StringProperty getWarningLabel(){return warningLabel;}


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        heaterStatus.setValue(model.getHeaterPower());
        otTemp.setValue(model.getOutsideTemperature());
        Platform.runLater(()-> {

            try {
                if((double) evt.getNewValue() > 25){
                    warningLabel.set("Temperature " + evt.getPropertyName() + " is too High");
                } else if((double) evt.getNewValue() < 10){
                    warningLabel.set("Temperature " + evt.getPropertyName() + "is to Low");
                } else {
                    warningLabel.set("");
                }
            } catch (Exception e){
                //
            }


            switch (evt.getPropertyName()){
                case "t1":
                    temp1.setValue((double) evt.getNewValue());
                    break;
                case "t2":
                    temp2.setValue((double) evt.getNewValue());
                    break;


            }

        });


    }


}
