package patterns.command.two.three;

import patterns.command.two.Command;

/**
 * @Auther d
 * @Date 2022/4/4 11:07
 * @Describe
 **/
public class StereoOffWithCDCommand implements Command {
    Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }
}
