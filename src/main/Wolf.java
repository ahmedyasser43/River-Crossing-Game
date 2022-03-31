package main;

import javafx.scene.image.Image;

public class Wolf extends Carnivorous
{
    private static Wolf wolf;
    String Label;
    private Wolf()
    {
    }
    public static Wolf getWolf()
    {
        if(wolf == null)
            wolf = new Wolf();
        return wolf;
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
        return 3;
    }

    @Override
    public Image getImages()
    {
        Image image = null;
        return image;
    }

    @Override
    public String setlabelToBeShown(String label)
    {
        Label= label;
        return Label;
    }

    @Override
    public String getLabelToBeShown()
    {
        return Label;
    }
}
