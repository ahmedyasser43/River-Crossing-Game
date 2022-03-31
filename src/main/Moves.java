package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Moves
{
    ArrayList<Sprite> boatsprites;
    ArrayList<Sprite> rightsprites;
    ArrayList<Sprite> leftsprites;
    ArrayList<ICrosser> left;
    ArrayList<ICrosser> right;
    ArrayList<ICrosser> boat;
    Stack<List<Sprite>> undo;
    Stack<List<Sprite>> redo;
    public Moves()
    {
        boatsprites = new ArrayList<>();
        rightsprites = new ArrayList<>();
        leftsprites = new ArrayList<>();
        left = new ArrayList<>();
        right = new ArrayList<>();
        boat = new ArrayList<>();
    }

}
