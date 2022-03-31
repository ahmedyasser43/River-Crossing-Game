package main;

import javafx.scene.image.Image;

public interface ICrosser
{
    int weight=0;
    boolean canSail();
    int getWeight();
    int getEatingRank();
    Image getImages();
    String setlabelToBeShown(String label);
    String getLabelToBeShown();

}
