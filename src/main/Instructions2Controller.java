package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Instructions2Controller implements Initializable {
    @FXML AnchorPane pane;
    Stage stage;
  @FXML  Label InstructionsLabel;
    Level2Screen game;
    Level2 level2;
   //InstructionsLabel.setText(.getInstructions());

    public Instructions2Controller()
    {
        game = new Level2Screen();
    }

    @FXML
    void start(ActionEvent event)
    {
        Stage currentStage = (Stage) pane.getScene().getWindow();
        Stage stage = new Stage();
        GridPane root = new GridPane();
        Button n = new Button("da");
        root.add(n,1,1);
        game.drawlevel2();
        currentStage.setScene(game.getScene());
        currentStage.show();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("First.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.setScene(first);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        level2 = Level2.getLevel2();
        game = new Level2Screen();
        String str = level2.getInstructions();
       // System.out.println(str);
        InstructionsLabel.setText(str);

    }
}
