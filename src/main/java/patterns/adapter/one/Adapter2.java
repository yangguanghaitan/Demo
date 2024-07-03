package patterns.adapter.one;

/**
 * @Auther d
 * @Date 2024/7/3 14:06
 * @Describe 对象适配器模式
 **/
public class Adapter2 implements Target {

    /**
     * 这是两种实现方式唯一的不同之处
     */
    private Adaptee adaptee;

    public Adapter2() {
        this.adaptee = new Adaptee();
    }

    /**
     * 采用组合的方式实现转换功能
     */
    public void doubleHoleSocket() {
        // 调用组合成员的方法，对其进行增强或处理
        this.adaptee.commonThreeHoleSocket();
        System.out.println("==========开始转换==========");
        System.out.println("oh，我变成了两孔插座");
    }

}
