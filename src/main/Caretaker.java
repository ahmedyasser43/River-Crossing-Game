package main;

import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> savedLists= new ArrayList<Memento>();
    public void addMemento(Memento m){
        savedLists.add(m);
    }
    public Memento getMemento(int i){
        return savedLists.get(i);
    }
}
