package patterns.command.two.three;

/**
 * @Auther d
 * @Date 2022/4/4 10:52
 * @Describe 电器之音响
 **/
public class Stereo {
    int volume;
    public void on() {
        System.out.println("Stereo is on");
    }
    public void off() {   System.out.println("Stereo is off");
    }
    public void setCd() {   System.out.println("Stereo is setCd");
    }
    public void setDvd() {   System.out.println("Stereo is setDvd");
    }
    public void setVolume(int volume) {
        volume=volume;
        System.out.println("Stereo is setVolume");
    }
    public void setRadio() { System.out.println("garageDoor is setRadio");
    }
}
