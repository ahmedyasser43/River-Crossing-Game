package main;

public class MenuOptions {
    Command level1command;
    Command level2command;

    public MenuOptions(Command level1command,Command level2command) {
        this.level1command=level1command;
        this.level2command=level2command;
    }
    public void clicklevel1()
    {
        level1command.execute();;
    }
    public void clicklevel2()
    {
        level2command.execute();;
    }
}
