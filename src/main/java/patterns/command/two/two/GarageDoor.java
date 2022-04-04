package patterns.command.two.two;

/**
 * @Auther d
 * @Date 2022/4/4 10:08
 * @Describe 电器之电动车库门
 **/
public class GarageDoor {

    public void up() {
        System.out.println("garageDoor is up");
    }
    public void down(){
        System.out.println("garageDoor is down");
    }
    public void stop(){
        System.out.println("garageDoor is stop");
    }
    public void lightOn(){
        System.out.println("garageDoor is lightOn");
    }
    public void lightOff(){
        System.out.println("garageDoor is lightOff");
    }
}
