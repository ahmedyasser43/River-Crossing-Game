package main;

import java.util.List;

public class Originator {
    private List list;
    private int score;
    public void setList(List newList){
        list= newList;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Memento storeInMemento(){
        return new Memento(list,score);
    }
    public List restoreListFromMemento(Memento memento){
        list= memento.getSavedList();
        return list;
    }
    public int restoreScoreFromMemento(Memento memento)
    {
        score =memento.getScore();
        return score;
    }
}
