package main;

public class Receiver {
   User user;

    public Receiver() {
        user= User.getUser();
    }

    public void level1(){
        System.out.println("level 1");
        user.newGame(1);
    }
    public void level2(){
        System.out.println("level 2");
        user.newGame(2);
    }
}
