package patterns.command.two.one;

import patterns.command.two.Command;

/**
 * @Auther d
 * @Date 2022/4/4 9:38
 * @Describe
 **/
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
