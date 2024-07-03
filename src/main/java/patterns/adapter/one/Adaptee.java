package patterns.adapter.one;

/**
 * @Auther d
 * @Date 2024/7/3 14:02
 * @Describe Adaptee（被适配对象）
 **/
public class Adaptee {
    /**
     * 需要被适配的功能
     * 这里用插座转换举例
     */
    public void commonThreeHoleSocket(){
        System.out.println("hi，我是一个常见的三孔插座");
    }

}
