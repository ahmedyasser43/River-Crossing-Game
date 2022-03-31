package main;

import javafx.scene.image.Image;

public class Rabbit extends Herbivorous
{
    private static  Rabbit rabbit;
    String Label;
    int weight;
    private Rabbit()
    {
    }
    public static Rabbit getRabbit()
    {
        if( rabbit == null)
        {
            rabbit = new Rabbit();
        }
        return rabbit;
    }
    @Override
    public boolean canSail()
    {
        return false;
    }

    @Override
    public int getWeight()
    {
        return weight;
    }

    @Override
    public int getEatingRank()
    {
        return 2;
    }

    @Override
    public Image getImages()
    {
        Image image = new Image("Rabbit.png");
        return image;
    }


    @Override
    public String setlabelToBeShown(String label)
    {
        Label = label;
        return Label;
    }

    @Override
    public String getLabelToBeShown()
    {
        return Label;
    }
    public void setWeight(int weight)
    {
        this.weight= weight;
    }
}
