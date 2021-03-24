import javafx.application.Application;
import javafx.stage.Stage;
import model.TemperatureModel;
import model.TemperatureModelManager;
import model.Thermometer;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application {

    private Thermometer thermometer1;
    private Thermometer thermometer2;

    public void start(Stage primaryStage){
        TemperatureModel model = new TemperatureModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);

        thermometer1 = new Thermometer(model,"t1", 15, 1);
        thermometer2 = new Thermometer(model, "t2", 15, 7);
        Thread t1 = new Thread(thermometer1,"t1");
        Thread t2 = new Thread(thermometer2,"t1");
        t1.start();
        t2.start();


    }

    public void stop(){
        thermometer1.stop();
        thermometer2.stop();
    }

}
