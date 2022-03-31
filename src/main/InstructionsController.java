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

public class InstructionsController implements Initializable {
    Ocean ocean;
    @FXML AnchorPane pane;
    Stage stage;
   @FXML Label InstructionsLabel;
    GameScreenController game;
    Stage window;
    User user;;
    Level1 level1;




public InstructionsController()
    {
        level1 = Level1.getLevel1();
    }
    @FXML
    public void initialize(){
        level1 =Level1.getLevel1();
        //user = new User();
        //GridPane root = new GridPane();
        game = new GameScreenController();
        String str = level1.getInstructions();
        // toString(level1.getInstructions());
        //InstructionsLabel = new Label(str);
        //InstructionsLabel.setText(str);
        InstructionsLabel.setText("hel");
        //root.add(InstructionsLabel,1,3);

    }


    public void getWindow(Stage stage)
    {
        this.window = stage;
    }

    @FXML
    void start(ActionEvent event) throws IOException
    {
       // InstructionsLabel.setText(level1.getInstructions());
        Stage currentStage = (Stage) pane.getScene().getWindow();
        Stage stage = new Stage();
        GridPane root = new GridPane();
        Button n = new Button("da");
        root.add(n,1,1);
        game.drawGame();
        currentStage.setScene(game.getScene());
        currentStage.show();
        //currentStage.close();
    }

////
    @FXML
    void back(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("First.fxml"));
        Scene first = new Scene(pane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(first);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        level1 = Level1.getLevel1();
        game = new GameScreenController();
        String str = level1.getInstructions();
        InstructionsLabel.setText(str);

    }
    void setGame(GameScreenController game)
    {
        this.game = game;
    }


}
