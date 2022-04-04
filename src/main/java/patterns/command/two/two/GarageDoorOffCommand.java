package patterns.command.two.two;

import patterns.command.two.Command;

/**
 * @Auther d
 * @Date 2022/4/4 10:12
 * @Describe
 **/
public class GarageDoorOffCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOffCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
