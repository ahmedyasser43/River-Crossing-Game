package main;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;

public class GameScreenController
{
    Level1 level1;
    InstructionsController instructionsController;
    Group pane;
    Group pane1;
    Canvas canvas;
    Scene scene,scene1;
    //Sprite raft;
    String move,mover;
    String[] moves;
    File f;
    int sails,count,mcount,m;
    ArrayList<Sprite> boatCrossers;
    ArrayList<Sprite> rightBankCrossers;
    int j ,leftcount,x , flag;
    Button go;
    Button goleft,undo , redo;
    Button pause;
    User user;
    ArrayList<Sprite> leftBankCrossers;
    ArrayList<Sprite> sprites;
    ArrayList<ICrosser> leftbank;
    ArrayList<ICrosser> rightbank;
    ArrayList<ICrosser> boatcrossers;
    Label score , flabel,llabel,rlabel,plabel;
    Label Alert;
    ScoreController Score;
    static double farmerx,farmery,lionx,liony,rabbitx,rabbity,plantx,planty,raftx,rafty;
    static int loadscore;
    BufferedReader br;
    BufferedWriter bw;
    {

    }

    //private static GameScreenController game;
    public GameScreenController()
    {
        m=0;
        mcount=0;
        f = new File("src/Moves.txt");
        //level1 = Level1.getLevel1();
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        moves = new String[50];
        pane = new Group();
        pane1 = new Group();
        Score = new ScoreController();
        canvas = new Canvas();
        count =0;
        x=0;
        //raft = new Sprite(new Image("Raft.png"));
        go = new Button();
        goleft = new Button();
        undo = new Button();
        redo = new Button();
        pause = new Button();
        score = new Label();
        leftBankCrossers = new ArrayList<>();
        j=0;
        move = null;
        mover = null;
        //sails =0;
        flag =0;
        rightBankCrossers = new ArrayList<Sprite>();
        boatCrossers = new ArrayList<Sprite>();
        sprites = new ArrayList<>();
        flabel = new Label();
        llabel = new Label();
        rlabel = new Label();
        plabel = new Label();
        Alert = new Label();
        leftbank = new ArrayList<>();
        rightbank = new ArrayList<>();
        boatcrossers = new ArrayList<>();
        farmerx = 75;
        farmery = 550;
        lionx = 150;
        liony = 450;
        rabbitx = 170;
        rabbity = 500;
        plantx = 180;
        planty= 400;
        raftx= 500;
        rafty = 400;
        loadscore =0;
        //pane.getChildren().addAll(canvas, go, goleft, pause,score,Alert,flabel,plabel,llabel,rlabel,redo,undo);
        //scene = new Scene(pane, 1500, 800);
    }
  /*  public static GameScreenController getGame()
    {
        if(game ==null)
            game = new GameScreenController();
        return game;
    }*/
    public Scene getScene()
    {
        return this.scene;
    }

    public void setInstructionsController (InstructionsController instructionsController){
        this.instructionsController=instructionsController;
}
    public void drawGame() {
        level1 = Level1.getLevel1();
        level1.farmer1.posX = farmerx;
        level1.farmer1.posY = farmery;
        level1.lion1.posX = lionx;
        level1.lion1.posY = liony;
        level1.rabbit1.posX = rabbitx;
        level1.rabbit1.posY = rabbity;
        level1.plant1.posX = plantx;
        level1.plant1.posY = planty;
        level1.raft.posX = raftx;
        level1.raft.posY = rafty;
        sails = loadscore;
        user = User.getUser();
        //scene = new Scene(pane, 1500, 800);
        go.setTranslateX(600);
        go.setTranslateY(600);
        goleft.setTranslateX(800);
        goleft.setTranslateY(600);
        pause.setTranslateX(1400);
        go.setGraphic(new ImageView("Button.png"));
        go.setStyle("-fx-background-color: transparent ");
        goleft.setGraphic(new ImageView("Buttonleft.png"));
        goleft.setStyle("-fx-background-color: transparent ");
        goleft.setDisable(true);
        go.setDisable(true);
        undo.setGraphic(new ImageView("undo.png"));
        undo.setStyle("-fx-background-color: transparent ");
        redo.setGraphic(new ImageView("redo.png"));
        redo.setStyle("-fx-background-color: transparent ");
        undo.setTranslateY(400);
        redo.setTranslateY(400);
        redo.setTranslateX(1400);
        pause.setGraphic(new ImageView("Pause.png"));
        pause.setStyle("-fx-background-color: transparent ");
        undo.setDisable(true);
        redo.setDisable(false);
        Image image = new Image("LeftBank.png");
        Image image1 = new Image("River.png");
        Image image2 = new Image("RightBank.png");
        //Image image3 = new Image("Button.png");
        Canvas canvas = new Canvas(1500, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        gc.drawImage(image1, 500, 0);
        gc.drawImage(image2, 1200, 0);
        level1.rabbit.setlabelToBeShown("Eating Rank: 2");
        level1.lion.setlabelToBeShown("Eating Rank: 3");
        level1.plant.setlabelToBeShown("Eating Rank: 1");
        //flabel.setText("adas");
        //flabel.setText(level1.farmer.getLabelToBeShown());
        plabel.setText(level1.plant.getLabelToBeShown());
        rlabel.setText(level1.rabbit.getLabelToBeShown());
        llabel.setText(level1.lion.getLabelToBeShown());
        //gc.drawImage(image3,700,740);
        level1.farmer1.setPosX(level1.farmer1.posX);
        level1.farmer1.setPosY(level1.farmer1.posY);
        level1.farmer1.render(gc);
        //flabel.setTranslateX(level1.farmer1.posX);
        //flabel.setTranslateY();
        level1.lion1.setPosX(level1.lion1.posX);
        level1.lion1.setPosY(level1.lion1.posY);
        level1.lion1.render(gc);
        llabel.setTranslateX(level1.lion1.posX);
        llabel.setTranslateY(level1.lion1.posY+35);
        level1.rabbit1.setPosX(level1.rabbit1.posX);
        level1.rabbit1.setPosY(level1.rabbit1.posY);
        level1.rabbit1.render(gc);
        rlabel.setTranslateX(level1.rabbit1.posX);
        rlabel.setTranslateY(level1.rabbit1.posY+60);
        level1.plant1.setPosY(level1.plant1.posY);
        level1.plant1.setPosX(level1.plant1.posX);
        level1.plant1.render(gc);
        plabel.setTranslateX(level1.plant1.posX+10);
        plabel.setTranslateY(level1.plant1.posY+50);
        Alert.setTranslateX(600);
        level1.raft.setPosX(level1.raft.posX);
        level1.raft.setPosY(level1.raft.posY);
        level1.raft.render(gc);
        score.setTranslateX(1245);
        score.setTranslateY(600);
        score.setText("Number of Sails:"+sails);
        score.setFont(Font.font("Verdana",25));
        scene = new Scene(pane,1500,800);
        HBox btnbox = new HBox(10);
        btnbox.setAlignment(Pos.BOTTOM_CENTER);
        btnbox.getChildren().add(go);
        pane.getChildren().addAll(canvas, btnbox, goleft, pause,score,Alert,flabel,plabel,llabel,rlabel,redo,undo);

        if(level1.raft.posX==900)
        {
            goleft.setDisable(false);
            flag =1;
        }
        else if(level1.raft.posX==500)
        {
            go.setDisable(false);
            flag=0;
        }
        sprites.add(level1.farmer1);
        sprites.add(level1.lion1);
        sprites.add(level1.rabbit1);
        sprites.add(level1.plant1);
        sprites.add(level1.raft);
        for(int i=0;i<4;i++)
        {
            if(sprites.get(i).posX<500&&sprites.get(i).equals(level1.farmer1))
            {
                leftBankCrossers.add(level1.farmer1);
                leftbank.add(level1.farmer);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level1.lion1))
            {
                leftBankCrossers.add(level1.lion1);
                leftbank.add(level1.lion);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level1.rabbit1))
            {
                leftBankCrossers.add(level1.rabbit1);
                leftbank.add(level1.rabbit);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level1.plant1))
            {
                leftBankCrossers.add(level1.plant1);
                leftbank.add(level1.plant);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level1.farmer1))
            {
                boatCrossers.add(level1.farmer1);
                boatcrossers.add(level1.farmer);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level1.lion1))
            {
                boatCrossers.add(level1.lion1);
                boatcrossers.add(level1.lion);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level1.rabbit1))
            {
                boatCrossers.add(level1.rabbit1);
                boatcrossers.add(level1.rabbit);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level1.plant1))
            {
                boatCrossers.add(level1.plant1);
                boatcrossers.add(level1.plant);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level1.farmer1))
            {
                rightBankCrossers.add(level1.farmer1);
                rightbank.add(level1.farmer);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level1.lion1))
            {
                rightBankCrossers.add(level1.lion1);
                rightbank.add(level1.lion);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level1.rabbit1))
            {
                rightBankCrossers.add(level1.rabbit1);
                rightbank.add(level1.rabbit);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level1.plant1))
            {
                rightBankCrossers.add(level1.plant1);
                rightbank.add(level1.plant);
            }
        }
        j=boatCrossers.size();
        this.scene.setOnMouseClicked(e -> {
            int x = (int) e.getX();
            int y = (int) e.getY();
            leftcount = j;
            //int temp=0;
            //for (int i = 0; i < leftBankCrossers.size(); i++) {
            //temp = i;
            if (x <= 500 && j < 2 && flag == 0) {
                for (int i =0;i<leftBankCrossers.size();i++)
                {
                    if (leftBankCrossers.get(i).contains(e.getX(), e.getY())) {
                        Alert.setText("");
                        if (leftBankCrossers.get(i).equals(level1.farmer1)) {
                            leftBankCrossers.get(i).setDeltaX(470);
                            leftBankCrossers.get(i).setDeltaY(-140);
                            leftbank.remove(level1.farmer);
                            boatcrossers.add(level1.farmer);
                            go.setDisable(false);
                        } else if (leftBankCrossers.get(i).equals(level1.rabbit1)) {
                            leftBankCrossers.get(i).setDeltaX(560);
                            leftBankCrossers.get(i).setDeltaY(-30);
                            boatcrossers.add(level1.rabbit);
                            leftbank.remove(level1.rabbit);
                        } else if (leftBankCrossers.get(i).equals(level1.lion1)) {
                            leftBankCrossers.get(i).setDeltaX(470);
                            leftBankCrossers.get(i).setDeltaY(40);
                            leftbank.remove(level1.lion);
                            boatcrossers.add(level1.lion);
                        } else if (leftBankCrossers.get(i).equals(level1.plant1)) {
                            leftBankCrossers.get(i).setDeltaX(490);
                            leftBankCrossers.get(i).setDeltaY(100);
                            leftbank.remove(level1.plant);
                            boatcrossers.add(level1.plant);
                        }
                        boatCrossers.add(leftBankCrossers.get(i));
                        leftBankCrossers.remove(i);
                        j++;
                    }
                }
            }
            //else break;

            //leftBankCrossers.remove(temp);
            leftcount = j;
            if (x > 500 && flag == 0) {
                for (int a = 0; a < boatCrossers.size(); a++) {

                    if (boatCrossers.get(a).contains(e.getX(), e.getY())) {
                        Alert.setText("");
                        if (boatCrossers.get(a).equals(level1.farmer1)) {
                            go.setDisable(true);
                            boatCrossers.get(a).setDeltaX(-470);
                            boatCrossers.get(a).setDeltaY(140);
                            leftbank.add(level1.farmer);
                        } else if (boatCrossers.get(a).equals(level1.rabbit1)) {
                            boatCrossers.get(a).setDeltaX(-560);
                            boatCrossers.get(a).setDeltaY(30);
                            leftbank.add(level1.rabbit);
                        } else if (boatCrossers.get(a).equals(level1.lion1)) {
                            boatCrossers.get(a).setDeltaX(-470);
                            boatCrossers.get(a).setDeltaY(-40);
                            leftbank.add(level1.lion);
                        } else if (boatCrossers.get(a).equals(level1.plant1)) {
                            boatCrossers.get(a).setDeltaX(-490);
                            boatCrossers.get(a).setDeltaY(-100);
                            leftbank.add(level1.plant);
                        }
                        leftBankCrossers.add(boatCrossers.get(a));
                        boatCrossers.remove(a);
                        j--;
                    }
                }
            }
            leftcount = j;
            if (x > 500 && flag == 1) {
                for (int a = 0; a < boatCrossers.size(); a++) {

                    if (boatCrossers.get(a).contains(e.getX(), e.getY())) {
                        Alert.setText("");
                        if (boatCrossers.get(a).equals(level1.farmer1)) {
                            go.setDisable(true);
                            goleft.setDisable(true);
                            boatCrossers.get(a).setDeltaX(430);
                            boatCrossers.get(a).setDeltaY(-90);
                            rightbank.add(level1.farmer);
                        } else if (boatCrossers.get(a).equals(level1.rabbit1)) {
                            boatCrossers.get(a).setDeltaX(250);
                            boatCrossers.get(a).setDeltaY(-30);
                            rightbank.add(level1.rabbit);
                        } else if (boatCrossers.get(a).equals(level1.lion1)) {
                            boatCrossers.get(a).setDeltaX(350);
                            boatCrossers.get(a).setDeltaY(40);
                            rightbank.add(level1.lion);
                        } else if (boatCrossers.get(a).equals(level1.plant1)) {
                            boatCrossers.get(a).setDeltaX(350);
                            boatCrossers.get(a).setDeltaY(100);
                            rightbank.add(level1.plant);
                        }
                        rightBankCrossers.add(boatCrossers.get(a));
                        boatCrossers.remove(a);
                        j--;
                        if(rightBankCrossers.size()==4)
                        {
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("Score.fxml"));
                            } catch (IOException exception) {
                                exception.printStackTrace();
                            }
                            //Stage currentstage = (Stage) pane.getScene().getWindow();
                            Stage stage = (Stage) pane.getScene().getWindow();
                            Scene scene2 = new Scene(root);
                            stage.setScene(scene2);
                            stage.show();
                        }
                    }
                }
            }

            if (x > 1200 && j<2) {
                for (int a = 0; a < rightBankCrossers.size(); a++) {

                    if (rightBankCrossers.get(a).contains(e.getX(), e.getY())) {
                        Alert.setText("");
                        if (rightBankCrossers.get(a).equals(level1.farmer1)) {
                            go.setDisable(true);
                            goleft.setDisable(false);
                            rightBankCrossers.get(a).setDeltaX(-430);
                            rightBankCrossers.get(a).setDeltaY(90);
                            rightbank.remove(level1.farmer);
                        } else if (rightBankCrossers.get(a).equals(level1.rabbit1)) {
                            rightBankCrossers.get(a).setDeltaX(-250);
                            rightBankCrossers.get(a).setDeltaY(30);
                            rightbank.remove(level1.rabbit);
                        } else if (rightBankCrossers.get(a).equals(level1.lion1)) {
                            rightBankCrossers.get(a).setDeltaX(-350);
                            rightBankCrossers.get(a).setDeltaY(-40);
                            rightbank.remove(level1.lion);
                        } else if (rightBankCrossers.get(a).equals(level1.plant1)) {
                            rightBankCrossers.get(a).setDeltaX(-350);
                            rightBankCrossers.get(a).setDeltaY(-100);
                            rightbank.remove(level1.plant);
                        }
                        boatCrossers.add(rightBankCrossers.get(a));
                        rightBankCrossers.remove(a);
                        j++;
                    }
                }
            }
        });
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, 1500, 800);
                gc.drawImage(image, 0, 0);
                gc.drawImage(image1, 500, 0);
                gc.drawImage(image2, 1200, 0);
                level1.raft.render(gc);
                for (int i = 0; i < 4; i++)
                {
                    sprites.get(i).update();
                    sprites.get(i).render(gc);
                    rlabel.setTranslateX(level1.rabbit1.posX);
                    rlabel.setTranslateY(level1.rabbit1.posY+60);
                    llabel.setTranslateX(level1.lion1.posX);
                    llabel.setTranslateY(level1.lion1.posY+35);
                    plabel.setTranslateX(level1.plant1.posX+10);
                    plabel.setTranslateY(level1.plant1.posY+40);
                    //rlabel.setTranslateX(level1.rabbit1.posX);
                    //rlabel.setTranslateY(level1.rabbit1.posY+60);
                }



            }
        }.start();
        //User.sprites = sprites;
        //user.undo.push(User.sprites);
        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                move = Double.toString(level1.raft.posX)+","+Double.toString(level1.raft.posY)+","+Double.toString(level1.farmer1.posX)+","+Double.toString(level1.farmer1.posY)+","+Double.toString(level1.rabbit1.posX)+","+Double.toString(level1.rabbit1.posY)+","+Double.toString(level1.lion1.posX)+","+Double.toString(level1.lion1.posY)+","+Double.toString(level1.plant1.posX)+","+Double.toString(level1.plant1.posY)+"&";
                System.out.println(move);
                try {
                    bw = new BufferedWriter(new FileWriter(f,true));
                    bw.write(move);
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //User.sprites = sprites;
                user.spritescopy = new ArrayList<>();
                for(Sprite sprite: sprites){
                    // copy each sprit
                    //add it in the user sprit
                    //Sprite spriteCopy = new Sprite();
                    user.spriteCopy = new Sprite(sprite.getImage());
                    user.spriteCopy.setPosX(sprite.posX);
                    user.spriteCopy.setPosY(sprite.posY);
                    user.spritescopy.add(user.spriteCopy);
                }
                //user.undo.push(User.sprites);
                /*for(int i =0;i<sprites.size();i++)
                user.undo.push(user.spritescopy);
                for(int i =0;i<user.spritescopy.size();i++)
                {
                    System.out.println(User.sprites.get(i).posX);
                }*/
                // System.out.println(user.spritescopy.get(i).posX);
                //}
                boolean canMove = user.canMove(boatcrossers,boatcrossers.size());
                //              for (int x = 0; x < 2; x++) {
                //boatCrossers.get(x).equals(farmer1)
                if (canMove)
                {
                    if(level1.isValid(leftbank,rightbank)) {
                        undo.setDisable(false);
                        //          User.sprites = sprites;

                        user.undo.push(User.sprites);
                    }
                    new AnimationTimer() {
                        public void handle(long currentNanoTime) {

                            while (level1.raft.posX != 900) {
                                gc.clearRect(0, 0, 1500, 800);
                                gc.drawImage(image, 0, 0);
                                gc.drawImage(image1, 500, 0);
                                gc.drawImage(image2, 1200, 0);
                                level1.raft.setDeltaX(1);
                                level1.raft.update();
                                level1.raft.render(gc);
                                for (int i = 0; i < boatCrossers.size(); i++) {
                                    boatCrossers.get(i).setDeltaX(1);
                                    boatCrossers.get(i).update();
                                    boatCrossers.get(i).render(gc);
                                }
                                for (int i = 0; i < leftBankCrossers.size(); i++) {
                                    leftBankCrossers.get(i).update();
                                    leftBankCrossers.get(i).render(gc);
                                }
                                for (int i=0;i< rightBankCrossers.size();i++)
                                {
                                    rightBankCrossers.get(i).update();
                                    rightBankCrossers.get(i).render(gc);
                                }
                            }
                        }
                    }.start();
                    sails++;
                    score.setText("Number of Sails: "+sails);
                    score.setFont(Font.font("Verdana",25));
                    flag = 1;
                    go.setDisable(true);
                    goleft.setDisable(false);
                    ScoreController.score = sails;
                    user.SaveGame(sprites,sails);
                }
                else
                {

                    Alert alert = new Alert(javafx.scene.control.Alert.AlertType.WARNING);
                    alert.setTitle("");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("Can't perform this move!");

                    alert.showAndWait();
                }
                //break;
            }

            //}

        });
        goleft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int x = 0; x < boatCrossers.size(); x++) {
                    if (boatCrossers.get(x).equals(level1.farmer1))
                    {
                        if(level1.isValid(leftbank,rightbank)) {
                            new AnimationTimer() {
                                public void handle(long currentNanoTime) {

                                    while (level1.raft.posX != 500) {
                                        gc.clearRect(0, 0, 1500, 800);
                                        gc.drawImage(image, 0, 0);
                                        gc.drawImage(image1, 500, 0);
                                        gc.drawImage(image2, 1200, 0);
                                        level1.raft.setDeltaX(-1);
                                        level1.raft.update();
                                        level1.raft.render(gc);
                                        for (int i = 0; i <boatCrossers.size(); i++) {
                                            boatCrossers.get(i).setDeltaX(-1);
                                            boatCrossers.get(i).update();
                                            boatCrossers.get(i).render(gc);
                                        }
                                        for (int i = 0; i < leftBankCrossers.size(); i++) {
                                            leftBankCrossers.get(i).update();
                                            leftBankCrossers.get(i).render(gc);
                                        }
                                        for (int i = 0; i < rightBankCrossers.size(); i++) {
                                            rightBankCrossers.get(i).update();
                                            rightBankCrossers.get(i).render(gc);
                                        }
                                    }
                                }
                            }.start();
                            sails++;
                            score.setText("Number of Sails: "+sails);
                            flag = 0;
                            go.setDisable(false);
                            ScoreController.score = sails;
                            goleft.setDisable(true);
                            break;
                        }
                        else
                        {


                            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.WARNING);
                            alert.setTitle("");
                            alert.setHeaderText("WARNING");
                            alert.setContentText("Can't perform this move!");

                            alert.showAndWait();
                        }
                    }

                }
            }
        });

        pause.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                User.valid = 1;
                //PauseMenuController pausemenu = new PauseMenuController();
                User.sprites = sprites;
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage currentStage = (Stage) pane.getScene().getWindow();
                PauseMenuController.previousstage = (Stage) pane.getScene().getWindow();;
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            }
        });
        undo.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
      //          user.LoadGame();
        //        Stage currentstage = (Stage) pane.getScene().getWindow();
    //            drawundo();
                //Scene scene2 = new Scene(scene1);
          //      currentstage.setScene(scene1);
            //    currentstage.show();
            }
        });
    }

}
