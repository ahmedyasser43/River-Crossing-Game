package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Score2Controller implements Initializable {
    AnchorPane pane;
    Stage stage;
    static int score;
    @FXML
    private Label ScoreLabel;
    //ScoreLabel.setText(.getScore());

    @FXML
    void newGame(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("First.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();

    }

    @FXML
    void reset(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("Instructions2.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ScoreLabel.setText(""+score);

    }
}
