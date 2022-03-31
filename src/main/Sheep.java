package main;

import javafx.scene.image.Image;

public class Sheep extends Herbivorous
{
    private static Sheep sheep;
    String Label;
    private Sheep()
    {
    }
    public static Sheep getSheep()
    {
        if(sheep == null)
            sheep = new Sheep();
        return sheep;
    }

    @Override
    public boolean canSail()
    {
        return false;
    }

    @Override
    public int getWeight()
    {
        return 20;
    }

    @Override
    public int getEatingRank()
    {
        return 2;
    }

    @Override
    public Image getImages()
    {
        Image image = null;
        return image;
    }


    @Override
    public String setlabelToBeShown(String Label)
    {
        Label =label;
        return Label;
    }

    @Override
    public String getLabelToBeShown()
    {
        return label;
    }
}
