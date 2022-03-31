package main;

import javafx.scene.image.Image;

public class Lion extends Carnivorous
{
    private static Lion lion;
    String Label;
    private Lion()
    {
    }
    public static Lion getLion()
    {
        if(lion==null)
            lion = new Lion();
        return lion;
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
        Image image = new Image("Lion.png");
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
