package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.StringDoubleConverter;
import viewmodel.MainViewModel;

public class MainViewController {
    @FXML private TextField temp1;
    @FXML private TextField temp2;
    @FXML private TextField otTemp;
    @FXML private TextField heaterStatus;
    @FXML private Label warningLabel;


    private Region root;
    private MainViewModel mainViewModel;
    private ViewHandler viewHandler;


    public MainViewController(){

    }

    public void init(ViewHandler viewHandler, MainViewModel mainViewModel, Region root){
        this.viewHandler = viewHandler;
        this.mainViewModel = mainViewModel;
        this.root = root;

        Bindings.bindBidirectional(temp1.textProperty(), mainViewModel.getTemp1(),new StringDoubleConverter(0));

        Bindings.bindBidirectional(temp2.textProperty(), mainViewModel.getTemp2(),new StringDoubleConverter(0));

        Bindings.bindBidirectional(otTemp.textProperty(), mainViewModel.getOtTemp(),new StringDoubleConverter(0));
        Bindings.bindBidirectional(heaterStatus.textProperty(), mainViewModel.getHeaterStatus(),new StringDoubleConverter(-1));
        warningLabel.textProperty().bind(mainViewModel.getWarningLabel());

        temp1.setEditable(false);
        temp2.setEditable(false);
        otTemp.setEditable(false);
        heaterStatus.setEditable(false);


    }

    public Region getRoot(){return root;}

    public void reset(){mainViewModel.clear();}

    @FXML public void onUP(){
        mainViewModel.clickUP();

    }

    @FXML public void onDown(){
        mainViewModel.clickDown();

    }

    @FXML public void onShow(){
        viewHandler.openView("log");
    }




}
