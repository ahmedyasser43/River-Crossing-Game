package main;

import com.sun.istack.internal.NotNull;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Level1 implements ICrossingStrategy
{
    boolean valid;
    int currentscore;
    GameScreenController game;
    Farmer farmer;
    Lion lion;
    Plant plant;
    Rabbit rabbit;
    String Instructions;
    ArrayList<Sprite> crossers ;
    Sprite farmer1;
    Sprite lion1;
    Sprite rabbit1;
    Sprite plant1;
    Sprite raft;
    Stage stage;
    private static Level1 level1;
    private Level1()
    {
        //valid = true;
        currentscore = 0;
        farmer = new Farmer();
        lion = Lion.getLion();
        plant = Plant.getPlant();
        rabbit = Rabbit.getRabbit();
        crossers = new ArrayList<Sprite>();
        farmer1 = new Sprite(farmer.getImages());
        lion1 = new Sprite(lion.getImages());
        rabbit1 = new Sprite(rabbit.getImages());
        plant1 = new Sprite(plant.getImages());
        raft = new Sprite(new Image("Raft.png"));
        game = new GameScreenController();
    }
    public static Level1 getLevel1()
    {
        if(level1==null)
            level1 = new Level1();
        return level1;
    }

    @Override
    public boolean isValid(ArrayList<ICrosser> leftbank, ArrayList<ICrosser> rightbank)
    {
        boolean valid=true;
        if(leftbank.size()>1) {
            for (int i = 0; i < leftbank.size()-1 ; i++) {
                if (leftbank.get(i).getEatingRank()-leftbank.get(i+1).getEatingRank()==1||leftbank.get(i+1).getEatingRank()-leftbank.get(i).getEatingRank()==1){//(leftbank.get(i) == rabbit1 && leftbank.get(i + 1) == plant1 || leftbank.get(i) == rabbit1 && leftbank.get(i + 1) == lion1) {
                    valid = false;
                    break;
                } /*else if (leftbank.get(i + 1) == rabbit1 && leftbank.get(i) == plant1 || leftbank.get(i + 1) == rabbit1 && leftbank.get(i) == lion1) {
                    valid = false;
                }*/
            }
        }
        if(rightbank.size()>1) {
            for (int i = 1; i < rightbank.size(); i++) {
               // if(leftbank.get(i) == rabbit && leftbank.get(i + 1) == plant || leftbank.get(i) == rabbit && leftbank.get(i + 1) == lion) {
                if (rightbank.get(i).getEatingRank()-rightbank.get(i-1).getEatingRank()==1||rightbank.get(i-1).getEatingRank()-rightbank.get(i).getEatingRank()==1){//(leftbank.get(i) == rabbit1 && leftbank.get(i + 1) == plant1 || leftbank.get(i) == rabbit1 && leftbank.get(i + 1) == lion1) {
                    valid = false;
                    break;
                }/* else if (rightbank.get(i - 1) == rabbit && rightbank.get(i) == plant || rightbank.get(i - 1) == rabbit && rightbank.get(i) == lion) {
                    valid = false;
                }*/
            }
        }
        return valid;
    }

    @Override
    @NotNull
    public String getInstructions()
    {
        Instructions = "-Help the farmer move all\nhis animals and plant to\nthe other side of the river\nIf you leave the lion with\nthe rabbit it will eat it and\nif you leave the rabbit\nwith plant it will eat it\nThe farmer is the only one\nwho can raw and the raft\ncan't hold more than two.";
        return Instructions;
    }

    @Override
    public List<Sprite> getInitialCrossers()
    {

        crossers.add(farmer1);
        crossers.add(lion1);
        crossers.add(rabbit1);
        crossers.add(plant1);
        return crossers;
    }
}
