package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewmodel.LogViewModel;

public class LogViewController {
    @FXML private ListView<String> logList;
    private Region root;
    private LogViewModel logViewModel;
    private ViewHandler viewHandler;

    public LogViewController(){

    }

    public void init(ViewHandler viewHandler, LogViewModel logViewModel, Region root){
        this.viewHandler = viewHandler;
        this.root = root;
        this.logViewModel = logViewModel;

        logList.setItems(logViewModel.getLogs());
    }

    public void reset(){}

    public Region getRoot() {return root;}

    @FXML public void onBack(){
        viewHandler.openView("main");
    }
}
