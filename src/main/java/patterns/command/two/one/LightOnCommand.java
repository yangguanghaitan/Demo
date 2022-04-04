package patterns.command.two.one;

import patterns.command.two.Command;

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
