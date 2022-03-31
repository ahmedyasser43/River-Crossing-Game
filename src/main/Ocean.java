package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;

public class Ocean extends Application
{
    Stage window;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));
        Scene scene = new Scene(root);
        GameScreenController game = new GameScreenController();
        game.drawGame();/*
        window.setMinHeight(800);
        window.setMinWidth(800);
        window.setMaxWidth(800);
        window.setMaxHeight(800);
       */// window.resizableProperty().setValue(Boolean.FALSE);
        window.setResizable(false);
        window.setScene(scene);
        window.show();

    }
}
