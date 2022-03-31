package main;

import javafx.scene.image.Image;

public class Farmer implements ICrosser
{
    String label = null;
    int weight;

    @Override
    public  boolean canSail()
    {
        return true;
    }
    @Override
    public int getWeight()
    {
        this.weight = weight;
        return weight;
    }

    @Override
    public int getEatingRank()
    {
        return 4;
    }

    @Override
    public Image getImages()
    {
        Image image = new Image("Farmer.png");
        return image;
    }


    @Override
    public String setlabelToBeShown(String label)
    {
        this.label = label;
        return label;
    }

    @Override
    public String getLabelToBeShown()
    {
        return "asdasdasd";
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}
