package main;

import javafx.scene.image.Image;

public class Plant implements ICrosser
{
    String Label = null;
    private static Plant plant;
    private Plant()
    {
    }
    public static Plant getPlant()
    {
        if(plant == null)
        {
            plant = new Plant();
        }
        return plant;
    }
    @Override
    public boolean canSail()
    {
        return false;
    }

    @Override
    public int getWeight()
    {
        return 0;
    }

    @Override
    public int getEatingRank()
    {
        return 1;
    }

    @Override
    public Image getImages()
    {
        Image image = new Image ("Box.png");
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
}
