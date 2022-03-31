package main;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Level2 implements ICrossingStrategy
{
    int currentscore;
    Farmer farmer1;
    Farmer farmer2 ;
    Farmer farmer3;
    Farmer farmer4 ;
    Rabbit rabbit;
    String instructions;
    List<Sprite> crossers = new ArrayList<Sprite>();
    Sprite farmer11;
    Sprite farmer22;
    Sprite farmer33;
    Sprite farmer44;
    Sprite rabbit1;
    Sprite raft;
    String weight1 ,weight2,weight3,weight4,weight5;
    private static Level2 level2;
    private Level2()
    {
        currentscore = 0;
        farmer1 = new Farmer();
        farmer2 = new Farmer();
        farmer3 = new Farmer();
        farmer4 = new Farmer();
        rabbit = Rabbit.getRabbit();
        farmer11 = new Sprite(farmer1.getImages());
        farmer22 = new Sprite(farmer2.getImages());
        farmer33 = new Sprite(farmer3.getImages());
        farmer44 = new Sprite (farmer4.getImages());
        raft = new Sprite(new Image("Raft.png"));
        rabbit1 = new Sprite(rabbit.getImages());
        farmer1.setWeight(90);
        farmer2.setWeight(80);
        farmer3.setWeight(60);
        farmer4.setWeight(40);
        rabbit.setWeight(20);
        weight1 = Integer.toString(farmer1.getWeight());
        weight2 = Integer.toString(farmer2.getWeight());
        weight3 =Integer.toString (farmer3.getWeight());
        weight4 = Integer.toString(farmer4.getWeight());
        weight5 = Integer.toString(rabbit.getWeight());
    }
    public static Level2 getLevel2()
    {
        if(level2 == null)
            level2 = new Level2();
        return level2;
    }
    @Override
    public boolean isValid(ArrayList<ICrosser> boatcrossers, ArrayList<ICrosser> rightbank)
    {
        if(boatcrossers.size()>1)
        {
            if(boatcrossers.get(0).getWeight()+boatcrossers.get(1).getWeight()<=100) {
                System.out.println(boatcrossers.get(0).getWeight());
                return true;
            }
            else
                return false;
        }
        else return true;
    }

    @Override
    public String getInstructions()
    {
        instructions = "Help The 4 Farmers and their animal\nto cross the river. \nAll of the farmers can raw.\nThe raft can't bare a weight more than 100,the first farmer weighs 90,\n the," +
                "the second one weighs 80,\nthe third 60, the fourth 40 \nand the animal weighs 20.";
        return instructions;
    }

    @Override
    public List<Sprite> getInitialCrossers()
    {
        crossers.add(farmer11);
        crossers.add(farmer22);
        crossers.add(farmer33);
        crossers.add(farmer44);
        crossers.add(rabbit1);
        return crossers;
    }

}
