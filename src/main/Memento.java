package main;

import java.util.List;

public class Memento {
    private List list;
    private int score;
    public Memento(List sprites, int newScore){
        list=sprites;
        score=newScore;
    }
    public List getSavedList(){
        return list;
    }

    public int getScore() {
        return score;
    }

}
