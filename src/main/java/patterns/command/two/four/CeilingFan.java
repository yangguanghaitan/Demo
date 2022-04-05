package patterns.command.two.four;

/**
 * @Auther d
 * @Date 2022/4/5 7:42
 * @Describe 电器之吊扇
 **/
public class CeilingFan {
    //速度
    public static final int HIGH=3;//高
    public static final int MEDIUM=2;//中
    public static final int LOW=1;//低
    public static final int OFF=-1;//关闭

    private String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void high(){
        speed=HIGH;
        System.out.println(location +" is on high");
    }

    public void medium(){
        speed=MEDIUM;
        System.out.println(location +" is on medium");
    }

    public void low(){
        speed=LOW;
        System.out.println(location +" is on low");
    }

    public int getSpeed(){
        return speed;
    }

    public void off(){
        speed=OFF;
        System.out.println(location +" is on off");
    }

}
