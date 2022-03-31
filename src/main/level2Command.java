package main;

public class level2Command implements Command {
    Receiver receiver;

    public level2Command(Receiver receiver) {
        this.receiver= receiver;
    }
    @Override
    public void execute() {
        receiver.level2();
    }
}
