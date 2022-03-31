package main;

import java.util.ArrayList;
import java.util.List;

public interface ICrossingStrategy
{
    public boolean isValid(ArrayList<ICrosser> leftbank, ArrayList<ICrosser> rightbank);

    public String getInstructions();

    public List<Sprite> getInitialCrossers();
}
