package viewmodel;

import model.Temperature;
import model.TemperatureModel;
import view.MainViewController;

public class ViewModelFactory {
    private TemperatureModel model;
    private MainViewModel mainViewModel;
    private LogViewModel logViewModel;


    public ViewModelFactory(TemperatureModel model){
        this.model = model;
        mainViewModel = new MainViewModel(model);
        logViewModel = new LogViewModel(model);
    }

    public MainViewModel getMainViewModel(){return mainViewModel;}
    public LogViewModel getLogViewModel(){return logViewModel;}


}
