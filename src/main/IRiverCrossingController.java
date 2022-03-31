package main;

import java.util.List;

public interface IRiverCrossingController
{
    public void newGame(int level);

    public void resetGame(int level);

    public void getInstructions(int level);

    public void getCrossersOnRightBank();

    public void getCrossersOnLeftBank();

    public boolean isBoatOnLeftBank(int x,int y);

    public int getNumberOfSails();

    public boolean canMove(List boatCrossers,int size);

    public void doMove();

    public boolean canUndo();

    public boolean canRedo();

    public void Undo();

    public void Redo();

    public void SaveGame(List sprites,int score);

    public void LoadGame();

    public void SolveGame();

}
