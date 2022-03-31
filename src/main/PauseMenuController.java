package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenuController implements Initializable {
    @FXML AnchorPane pane;
    AnchorPane pane1;
    Stage stage;
    User user;
    static Stage previousstage;
    //GameScreenController game;

    public PauseMenuController()
    {
        user = User.getUser();
        previousstage = new Stage();
        //game = new GameScreenController();
    }

    @FXML
    void newgame(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("First.fxml"));
        //Stage stage =(Stage) game.pane.getScene().getWindow();
        //Stage currentstage = (Stage) GameScreenController.getPane().getScene().getWindow();
        Stage stage = new Stage();
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(first);
        previousstage.close();
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        //currentstage.close();
        window.close();
        stage.show();
    }

    @FXML
    void reset(ActionEvent event) throws IOException {

        pane1 = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Scene first = new Scene(pane1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage currentStage = (Stage) pane.getScene().getWindow();
        //currentStage.close();
        //Stage stage =(Stage) pane.getScene().getWindow();
        previousstage.setScene(first);
        currentStage.close();
        previousstage.show();
    }

    @FXML
    void save(ActionEvent event)
    {
        user.SaveGame(User.sprites,ScoreController.score);
    }

    @FXML
    void back(ActionEvent event) {
        Stage currentStage = (Stage) pane.getScene().getWindow();
        currentStage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //stage = (Stage)pane.getScene().getWindow();
       // stage.initStyle(StageStyle.UNDECORATED);
    }
}
