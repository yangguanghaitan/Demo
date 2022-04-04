package patterns.command.one.electrical.two;

import patterns.command.one.Command;

/**
 * @Auther d
 * @Date 2022/4/4 10:12
 * @Describe
 **/
public class GarageDoorOnCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOnCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
