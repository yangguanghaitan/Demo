package patterns.bridge;

/**
 * @Auther d
 * @Date 2023/2/8 15:33
 * @Describe
 **/
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
