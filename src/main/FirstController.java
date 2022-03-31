package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class FirstController implements Initializable {

    @FXML AnchorPane pane;
    Stage window;
    InstructionsController instructions1;
    Level1 level1;
    Level2Screen level2;
    User user;
    GameScreenController game;
    Receiver receiver;
    Command level1Command;
    Command level2Command;
    MenuOptions menu;
    public FirstController()
    {
        game = new GameScreenController();
        instructions1 = new InstructionsController();
        level2 = new Level2Screen();
        level1 = Level1.getLevel1();
        user = User.getUser();
        receiver=new Receiver();
        level1Command=new level1Command(receiver);
        level2Command=new level2Command(receiver);
        menu= new MenuOptions(level1Command,level2Command);
    }
    public void getWindow(Stage stage)
    {
        this.window = stage;
    }
    @FXML
    void level1(ActionEvent event) throws IOException {
       menu.clicklevel1();
        //user.newGame(1);
        pane = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(first);
        /*window.setMinHeight();
        window.setMinWidth(763);
        window.setMaxWidth(763);
        window.setMaxHeight(630);
        */window.setResizable(false);
        window.show();
    }

    @FXML
    void level2(ActionEvent event) throws IOException {
        menu.clicklevel2();
        ///user.newGame(2);
        pane = FXMLLoader.load(getClass().getResource("Instructions2.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.setScene(first);
        window.show();
    }
    @FXML
    void loadgame(ActionEvent event) throws IOException {
        System.out.println(user.getValid());
        user.LoadGame();
        if(user.getValid() == 1) {
            Stage currentStage = (Stage) pane.getScene().getWindow();
            //Stage stage = new Stage();
            game.drawGame();
            currentStage.setResizable(false);
            currentStage.setScene(game.getScene());
            currentStage.show();
        }
        else
        {
            Stage currentStage = (Stage) pane.getScene().getWindow();
            //Stage stage = new Stage();
            level2.drawlevel2();
            currentStage.setResizable(false);
            currentStage.setScene(level2.getScene());
            currentStage.show();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    void setGame(GameScreenController game)
    {
        this.game = game;
    }

    }