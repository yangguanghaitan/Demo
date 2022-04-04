package patterns.command.one.electrical.one;

import patterns.command.one.Command;

/**
 * @Auther d
 * @Date 2022/4/4 9:38
 * @Describe
 **/
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
