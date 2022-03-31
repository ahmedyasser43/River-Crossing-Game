package main;

public class level1Command implements Command {
    Receiver receiver;

    public level1Command(Receiver receiver) {
        this.receiver= receiver;
    }
    @Override
    public void execute() {
     receiver.level1();
    }
}
