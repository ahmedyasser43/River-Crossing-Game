package main;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level2Screen {
    Scene scene;
    Level2 level2;
    Button go, goleft, pause,undo,redo;
    //Sprite raft;
    List<Sprite> leftBankCrossers;
    List<Sprite> rightBankCrossers;
    List<Sprite> boatCrossers;
    ArrayList<Sprite> sprites;
    ArrayList<ICrosser> boatcrossers;
    ArrayList<ICrosser> crossers;
    int boat;
    User user;
    int flag;
    int sails;
    Label weight1,weight2,weight3,weight4,weight5,Alert,score;
    static double raftx,rafty,farmer1x,farmer1y,farmer2x,farmer2y,farmer3x,farmer3y,farmer4x,farmer4y,rabbitx,rabbity;
    static int loadscore;
    public Level2Screen() {
        flag = 0;
        sails = 0;
        user = User.getUser();
        boat = 0;
        go = new Button();
        goleft = new Button();
        pause = new Button();
        undo = new Button();
        redo = new Button();
        level2 = Level2.getLevel2();
        leftBankCrossers = new ArrayList<Sprite>();
        rightBankCrossers = new ArrayList<Sprite>();
        boatCrossers = new ArrayList<Sprite>();
        sprites = new ArrayList<Sprite>();
        boatcrossers = new ArrayList<>();
        crossers = new ArrayList<>();
        //raft = new Sprite(new Image("Raft.png"));
        weight1 = new Label(level2.weight1);
        weight2 = new Label(level2.weight2);
        weight3 = new Label(level2.weight3);
        weight4 = new Label(level2.weight4);
        weight5 = new Label(level2.weight5);
        Alert = new Label();
        score = new Label();
        raftx = 500;
        rafty = 400;
        farmer1x = 75;
        farmer1y = 550;
        farmer2x = 150;
        farmer2y = 450;
        farmer3x = 250;
        farmer3y = 350;
        farmer4x = 370;
        farmer4y = 285;
        rabbitx = 380;
        rabbity = 500;
        loadscore = 0;
    }

    void drawlevel2() {
        level2.raft.posX = raftx;
        level2.raft.posY = rafty;
        level2.farmer11.posX = farmer1x;
        level2.farmer11.posY = farmer1y;
        level2.farmer22.posX = farmer2x;
        level2.farmer22.posY = farmer2y;
        level2.farmer33.posX = farmer3x;
        level2.farmer33.posY = farmer3y;
        level2.farmer44.posX = farmer4x;
        level2.farmer44.posY = farmer4y;
        level2.rabbit1.posX = rabbitx;
        level2.rabbit1.posY = rabbity;
        sails = loadscore;
        Group pane = new Group();
        Canvas canvas = new Canvas(1500, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        scene = new Scene(pane, 1500, 800);
        leftBankCrossers = level2.getInitialCrossers();
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
        pause.setGraphic(new ImageView("Pause.png"));
        pause.setStyle("-fx-background-color: transparent ");
        undo.setGraphic(new ImageView("undo.png"));
        undo.setStyle("-fx-background-color: transparent ");
        redo.setGraphic(new ImageView("redo.png"));
        redo.setStyle("-fx-background-color: transparent ");
        undo.setTranslateY(400);
        redo.setTranslateY(400);
        redo.setTranslateX(1400);
        score.setTranslateX(1245);
        score.setTranslateY(600);
        score.setText("Number of Sails: "+loadscore);
        score.setFont(Font.font("Verdana",25));
        Image image = new Image("LeftBank.png");
        Image image1 = new Image("River.png");
        Image image2 = new Image("RightBank.png");
        gc.drawImage(image, 0, 0);
        gc.drawImage(image1, 500, 0);
        gc.drawImage(image2, 1200, 0);
        level2.raft.setPosX(level2.raft.posX);
        level2.raft.setPosY(level2.raft.posY);
        level2.raft.render(gc);
        level2.farmer11.setPosX(level2.farmer11.posX);
        level2.farmer11.setPosY(level2.farmer11.posY);
        weight1.setTranslateX(level2.farmer11.posX);
        weight1.setTranslateY(level2.farmer11.posX+15);
        level2.farmer11.render(gc);
        level2.farmer22.setPosX(level2.farmer22.posX);
        level2.farmer22.setPosY(level2.farmer22.posY);
        weight2.setTranslateX(level2.farmer22.posX);
        weight2.setTranslateY(level2.farmer22.posY+15);
        level2.farmer22.render(gc);
        level2.farmer44.setPosX(level2.farmer44.posX);
        level2.farmer44.setPosY(level2.farmer44.posY);
        weight4.setTranslateX(level2.farmer44.posX);
        weight4.setTranslateY(level2.farmer44.posY+15);
        level2.farmer44.render(gc);
        level2.farmer33.setPosX(level2.farmer33.posX);
        level2.farmer33.setPosY(level2.farmer33.posY);
        weight3.setTranslateX(level2.farmer33.posX);
        weight3.setTranslateY(level2.farmer33.posY+15);
        level2.farmer33.render(gc);
        level2.rabbit1.setPosX(level2.rabbit1.posX);
        level2.rabbit1.setPosY(level2.rabbit1.posY);
        weight5.setTranslateX(level2.rabbit1.posX);
        weight5.setTranslateY(level2.rabbit1.posY+15);
        level2.rabbit1.render(gc);
        leftBankCrossers.add(level2.farmer11);
        leftBankCrossers.add(level2.farmer22);
        leftBankCrossers.add(level2.farmer33);
        leftBankCrossers.add(level2.farmer44);
        leftBankCrossers.add(level2.rabbit1);
        pane.getChildren().addAll(canvas,score,redo,undo, go, goleft, pause,weight1,weight2,weight3,weight4,weight5,Alert);

        if(level2.raft.posX ==900)
        {
            goleft.setDisable(false);
            flag = 1;
        }
        else if(level2.raft.posX==500)
        {
            go.setDisable(false);
            flag=0;
        }
        sprites.add(level2.farmer11);
        sprites.add(level2.farmer22);
        sprites.add(level2.farmer33);
        sprites.add(level2.farmer44);
        sprites.add(level2.rabbit1);
        sprites.add(level2.raft);
        for(int i =0;i<5;i++)
        {
            if(sprites.get(i).posX<500&&sprites.get(i).equals(level2.farmer11))
            {
                leftBankCrossers.add(level2.farmer11);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level2.farmer22))
            {
                leftBankCrossers.add(level2.farmer22);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level2.farmer33))
            {
                leftBankCrossers.add(level2.farmer33);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level2.farmer44))
            {
                leftBankCrossers.add(level2.farmer44);
            }
            else if(sprites.get(i).posX<500&&sprites.get(i).equals(level2.rabbit1))
            {
                leftBankCrossers.add(level2.rabbit1);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level2.farmer11))
            {
                boatCrossers.add(level2.farmer11);
                boatcrossers.add(level2.farmer1);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level2.farmer22))
            {
                boatCrossers.add(level2.farmer22);
                boatcrossers.add(level2.farmer2);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level2.farmer33))
            {
                boatCrossers.add(level2.farmer33);
                boatcrossers.add(level2.farmer3);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level2.farmer44))
            {
                boatCrossers.add(level2.farmer44);
                boatcrossers.add(level2.farmer4);
            }
            else if(sprites.get(i).posX>500&&sprites.get(i).posX<1200&&sprites.get(i).equals(level2.rabbit1))
            {
                boatCrossers.add(level2.rabbit1);
                boatcrossers.add(level2.rabbit);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level2.farmer11))
            {
                rightBankCrossers.add(level2.farmer11);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level2.farmer22))
            {
                rightBankCrossers.add(level2.farmer22);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level2.farmer33))
            {
                rightBankCrossers.add(level2.farmer33);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level2.farmer44))
            {
                rightBankCrossers.add(level2.farmer44);
            }
            else if(sprites.get(i).posX>1200&&sprites.get(i).equals(level2.rabbit1))
            {
                rightBankCrossers.add(level2.rabbit1);
            }
        }
        this.scene.setOnMouseClicked(e-> {
            int x = (int) e.getX();
            int y = (int) e.getY();
            System.out.println(boatCrossers.size());
            if(x< 500&&boatCrossers.size()<2&&flag==0)
            {
                for(int i =0;i<leftBankCrossers.size();i++)
                {
                    if(leftBankCrossers.get(i).contains(e.getX(),e.getY()))
                    {
                        if(leftBankCrossers.get(i).equals(level2.farmer11))
                        {
                            leftBankCrossers.get(i).setDeltaX(470);
                            leftBankCrossers.get(i).setDeltaY(-150);
                            boatcrossers.add(level2.farmer1);
                            go.setDisable(false);
                            boat = i;
                            break;
                        }
                        else if(leftBankCrossers.get(i).equals(level2.farmer22))
                        {
                            leftBankCrossers.get(i).setDeltaX(450);
                            leftBankCrossers.get(i).setDeltaY(-50);
                            boatcrossers.add(level2.farmer2);
                            go.setDisable(false);
                            boat = i;
                            break;
                        }
                        else if(leftBankCrossers.get(i).equals(level2.farmer33))
                        {
                            leftBankCrossers.get(i).setDeltaX(400);
                            leftBankCrossers.get(i).setDeltaY(50);
                            boatcrossers.add(level2.farmer3);
                            go.setDisable(false);
                            boat = i;
                            break;
                        }
                        else if(leftBankCrossers.get(i).equals(level2.farmer44))
                        {
                            leftBankCrossers.get(i).setDeltaX(340);
                            leftBankCrossers.get(i).setDeltaY(120);
                            boatcrossers.add(level2.farmer4);
                            go.setDisable(false);
                            boat = i;
                            break;
                        }
                        else if(leftBankCrossers.get(i).equals(level2.rabbit1))
                        {
                            leftBankCrossers.get(i).setDeltaX(315);
                            leftBankCrossers.get(i).setDeltaY(-40);
                            boatcrossers.add(level2.rabbit);
                            boat = i;
                            break;
                        }
                        //boat = i;
                        //boatCrossers.add(leftBankCrossers.get(i));
                        //leftBankCrossers.remove(i);
                        //System.out.println(boat);
                        //boat++;
                    }
                    //boatCrossers.add(leftBankCrossers.get(boat));
                    //leftBankCrossers.remove(boat);
                    //boat++;
                }
                boatCrossers.add(leftBankCrossers.get(boat));
                leftBankCrossers.remove(boat);
                boat++;
            }
            else if(x>500&&flag==0)
            {
                for(int i =0;i<boatCrossers.size();i++)
                {
                    if(boatCrossers.get(i).contains(e.getX(),e.getY()))
                    {
                        if(boatCrossers.get(i).equals(level2.farmer11))
                        {
                            boatCrossers.get(i).setDeltaX(-470);
                            boatCrossers.get(i).setDeltaY(150);
                            boatcrossers.remove(level2.farmer1);
                            go.setDisable(false);
                        }
                        else if(boatCrossers.get(i).equals(level2.farmer22))
                        {
                            boatCrossers.get(i).setDeltaX(-450);
                            boatCrossers.get(i).setDeltaY(50);
                            boatcrossers.remove(level2.farmer2);
                            go.setDisable(false);
                        }
                        else if(boatCrossers.get(i).equals(level2.farmer33))
                        {
                            boatCrossers.get(i).setDeltaX(-400);
                            boatCrossers.get(i).setDeltaY(-50);
                            boatcrossers.remove(level2.farmer3);
                            go.setDisable(false);
                        }
                        else if(boatCrossers.get(i).equals(level2.farmer44))
                        {
                            boatCrossers.get(i).setDeltaX(-340);
                            boatCrossers.get(i).setDeltaY(-120);
                            boatcrossers.remove(level2.farmer4);
                            go.setDisable(false);
                        }
                        else if(boatCrossers.get(i).equals(level2.rabbit1))
                        {
                            boatCrossers.get(i).setDeltaX(-315);
                            boatCrossers.get(i).setDeltaY(40);
                            boatcrossers.remove(level2.rabbit);
                        }
                        leftBankCrossers.add(boatCrossers.get(i));
                        System.out.println("as"+boatCrossers.size());
                        boatCrossers.remove(i);
                    }
                }
                if(boatCrossers.size()==1&&boatCrossers.get(0).equals(level2.rabbit1)||boatCrossers.size()==0)
                {
                    go.setDisable(true);
                }
                //boat--;
            }
            if(x>500&&flag==1)
            {
                for(int i =0;i<boatCrossers.size();i++)
                {
                    if(boatCrossers.get(i).contains(e.getX(),e.getY()))
                    {
                        if(boatCrossers.get(i).equals(level2.farmer11))
                        {
                            boatCrossers.get(i).setDeltaX(430);
                            boatCrossers.get(i).setDeltaY(-90);
                            boatcrossers.remove(level2.farmer1);
                        }
                        else if(boatCrossers.get(i).equals(level2.farmer22))
                        {
                            boatCrossers.get(i).setDeltaX(250);
                            boatCrossers.get(i).setDeltaY(-50);
                            boatcrossers.remove(level2.farmer2);
                        }
                        else if(boatCrossers.get(i).equals(level2.farmer33))
                        {
                            boatCrossers.get(i).setDeltaX(350);
                            boatCrossers.get(i).setDeltaY(40);
                            boatcrossers.remove(level2.farmer3);
                        }
                        else if(boatCrossers.get(i).equals(level2.farmer44))
                        {
                            boatCrossers.get(i).setDeltaX(250);
                            boatCrossers.get(i).setDeltaY(200);
                            boatcrossers.remove(level2.farmer4);
                        }
                        else if(boatCrossers.get(i).equals(level2.rabbit1))
                        {
                            boatCrossers.get(i).setDeltaX(200);
                            boatCrossers.get(i).setDeltaY(60);
                            boatcrossers.remove(level2.rabbit);
                        }
                        rightBankCrossers.add(boatCrossers.get(i));
                        boatCrossers.remove(i);
                    }
                }
                if(boatCrossers.size()==1&&boatCrossers.get(0).equals(level2.rabbit1)||boatCrossers.size()==0)
                {
                    goleft.setDisable(true);
                }
                if(rightBankCrossers.size()==5)
                {
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("Score2.fxml"));
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    //Stage currentstage = (Stage) pane.getScene().getWindow();
                    Stage stage = (Stage) pane.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                //boat--;
            }
            if(x>1200&&boatCrossers.size()<2&&flag==1)
            {
                System.out.println("assssssssssss");
                for(int i =0;i<rightBankCrossers.size();i++)
                {
                    if(rightBankCrossers.get(i).contains(e.getX(),e.getY()))
                    {
                        System.out.println("assalsalsla");
                        if(rightBankCrossers.get(i).equals(level2.farmer11))
                        {
                            rightBankCrossers.get(i).setDeltaX(-430);
                            rightBankCrossers.get(i).setDeltaY(90);
                            boatcrossers.add(level2.farmer1);
                            goleft.setDisable(false);
                        }
                        else if(rightBankCrossers.get(i).equals(level2.farmer22))
                        {
                            rightBankCrossers.get(i).setDeltaX(-250);
                            rightBankCrossers.get(i).setDeltaY(50);
                            goleft.setDisable(false);
                            boatcrossers.add(level2.farmer2);
                        }
                        else if(rightBankCrossers.get(i).equals(level2.farmer33))
                        {
                            rightBankCrossers.get(i).setDeltaX(-350);
                            rightBankCrossers.get(i).setDeltaY(-40);
                            boatcrossers.add(level2.farmer3);
                            goleft.setDisable(false);
                        }
                        else if(rightBankCrossers.get(i).equals(level2.farmer44))
                        {
                            rightBankCrossers.get(i).setDeltaX(-250);
                            rightBankCrossers.get(i).setDeltaY(-200);
                            boatcrossers.add(level2.farmer4);
                            goleft.setDisable(false);
                        }
                        else if(rightBankCrossers.get(i).equals(level2.rabbit1))
                        {
                            rightBankCrossers.get(i).setDeltaX(-200);
                            rightBankCrossers.get(i).setDeltaY(-60);
                            boatcrossers.add(level2.rabbit);
                        }
                        boat =i;
                        break;
                    }
                }
                boatCrossers.add(rightBankCrossers.get(boat));
                rightBankCrossers.remove(boat);
                //boat--;
            }
        });
        new AnimationTimer(){
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0,0,1500,800);
                gc.drawImage(image, 0, 0);
                gc.drawImage(image1, 500, 0);
                gc.drawImage(image2, 1200, 0);
                level2.raft.render(gc);
                for(int i=0;i<5;i++)
                {
                    sprites.get(i).update();
                    sprites.get(i).render(gc);
                    weight1.setTranslateX(level2.farmer11.posX);
                    weight1.setTranslateY(level2.farmer11.posY+15);
                    weight2.setTranslateX(level2.farmer22.posX);
                    weight2.setTranslateY(level2.farmer22.posY+15);
                    weight3.setTranslateX(level2.farmer33.posX);
                    weight3.setTranslateY(level2.farmer33.posY+15);
                    weight4.setTranslateX(level2.farmer44.posX);
                    weight4.setTranslateY(level2.farmer44.posY+15);
                    weight5.setTranslateX(level2.rabbit1.posX);
                    weight5.setTranslateY(level2.rabbit1.posY+15);

                }
            }
        }.start();
        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(level2.isValid(boatcrossers,crossers))
                {
                    new AnimationTimer() {
                        @Override
                        public void handle(long currentNanoTime)
                        {
                            while(level2.raft.posX!=900)
                            {
                                gc.clearRect(0, 0, 1500, 800);
                                gc.drawImage(image, 0, 0);
                                gc.drawImage(image1, 500, 0);
                                gc.drawImage(image2, 1200, 0);
                                level2.raft.setDeltaX(1);
                                level2.raft.update();
                                level2.raft.render(gc);
                                for(int i =0;i<boatCrossers.size();i++)
                                {
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

                    flag =1;
                    goleft.setDisable(false);
                    go.setDisable(true);
                    Score2Controller.score = sails;
                }
                else
                {
                    javafx.scene.control.Alert alert = new Alert(javafx.scene.control.Alert.AlertType.WARNING);
                    alert.setTitle("");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("Can't perform this move!");

                    alert.showAndWait();
                }
            }
        });
        goleft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(level2.isValid(boatcrossers,crossers))
                {
                    new AnimationTimer() {
                        @Override
                        public void handle(long CurrentnanoTime)
                        {
                            while(level2.raft.posX!=500)
                            {
                                gc.clearRect(0, 0, 1500, 800);
                                gc.drawImage(image, 0, 0);
                                gc.drawImage(image1, 500, 0);
                                gc.drawImage(image2, 1200, 0);
                                level2.raft.setDeltaX(-1);
                                level2.raft.update();
                                level2.raft.render(gc);
                                for(int i =0;i<boatCrossers.size();i++)
                                {
                                    boatCrossers.get(i).setDeltaX(-1);
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
                    flag =0;
                    goleft.setDisable(true);

                    go.setDisable(false);
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
        });
        pause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                User.sprites = sprites;
                User.valid =2;
                try {
                    root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Stage currentStage = (Stage) pane.getScene().getWindow();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                PauseMenuController.previousstage = (Stage) pane.getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            }
        });
    }
    public Scene getScene()
    {
        return this.scene;
    }
}
