package viewmodel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener {
    private TemperatureModel model;
    private ObservableList<String> logs;

    public LogViewModel(TemperatureModel model){
        this.model = model;
        logs = FXCollections.observableArrayList();
        model.addListener(this);
    }

    public ObservableList<String> getLogs(){return logs;}

    @Override public void propertyChange(PropertyChangeEvent evt){
        Platform.runLater(()-> {
            if(evt.getPropertyName().equals("Log")){
                logs.add((String) evt.getNewValue());
            }
        });

    }


}
