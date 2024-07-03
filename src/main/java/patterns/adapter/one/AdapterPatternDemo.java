package patterns.adapter.one;

import patterns.adapter.one.Adapter;
import patterns.adapter.one.Target;

/**
 * @Auther d
 * @Date 2024/7/3 14:00
 * @Describe
 * 类适配器模式实现:继承被适配对象，同时实现目标接口即可
 * 对象适配器模式实现:实现目标接口即可
 **/
public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("#####################类适配器实现start");
        Target newPlug = new Adapter();
        // 对于使用者来说，它只需要知道适配器提供了一个两孔插头即可
        newPlug.doubleHoleSocket();
        System.out.println("这是一个两孔插头");
        System.out.println("#####################类适配器实现end");

        System.out.println("#####################对象适配器实现start");
        Target newPlug2 = new Adapter2();
        // 对于使用者来说，它只需要知道适配器提供了一个两孔插头即可
        newPlug2.doubleHoleSocket();
        System.out.println("这是一个两孔插头");
        System.out.println("#####################对象适配器实现end");

    }
}
