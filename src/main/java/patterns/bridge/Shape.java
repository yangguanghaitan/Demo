package patterns.bridge;

/**
 * @Auther d
 * @Date 2023/2/8 15:34
 * @Describe
 **/
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
