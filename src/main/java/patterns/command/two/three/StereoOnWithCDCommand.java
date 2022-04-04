package patterns.command.two.three;

import patterns.command.two.Command;

/**
 * @Auther d
 * @Date 2022/4/4 10:55
 * @Describe
 **/
public class StereoOnWithCDCommand implements Command {
    Stereo stereo;


    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        //设置音量
        stereo.setVolume(18);
    }
}
