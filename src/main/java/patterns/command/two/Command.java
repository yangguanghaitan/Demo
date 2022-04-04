package patterns.command.two;

public interface Command {
    public void execute();
    //实现撤销操作，取消上一步操作
    public void undo();
}
