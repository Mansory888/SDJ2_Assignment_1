package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;
    private ViewModelFactory viewModelFactory;
    private LogViewController logViewController;
    private MainViewController mainViewController;

    public ViewHandler(ViewModelFactory viewModelFactory){
        this.viewModelFactory = viewModelFactory;
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        openView("main");

    }

    public void openView(String id){
        Region root = null;

        switch (id){
            case "main":
                root = loadMainView("Ui.fxml");
                break;
            case "log":
                root = loadLogView("Log.fxml");
                break;

        }
        currentScene.setRoot(root);
        String title ="";
        if(root.getUserData() != null){
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void closeView(){primaryStage.close();}

    private Region loadMainView(String fxmFile){
        Region root = null;
        if(mainViewController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmFile));
                root = loader.load();
                mainViewController = loader.getController();
                mainViewController.init(this, viewModelFactory.getMainViewModel(), root);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            mainViewController.reset();
        }
        return mainViewController.getRoot();

    }

    private Region loadLogView(String fxmFile){
        Region root = null;
        if(logViewController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmFile));
                root = loader.load();
                logViewController = loader.getController();
                logViewController.init(this, viewModelFactory.getLogViewModel(), root);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            logViewController.reset();
        }
        return logViewController.getRoot();

    }
}
