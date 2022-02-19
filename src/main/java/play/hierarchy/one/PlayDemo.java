package play.hierarchy.one;

/**
 * @Auther d
 * @Date 2022/2/19 17:51
 * @Describe 测试多个类或者接口继承特性的位置
 * 1.先实例化父类在实例化子类，子类构造函数默认第一行是super();
 * 2，this()于super()只能有一个,super()在this()里肯定能保证执行
 **/
public class PlayDemo {
    public static void main(String[] args) {
        C c=new C();
        System.out.println("##############");

    }
}
