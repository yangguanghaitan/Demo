package play.hierarchy.one;

/**
 * @Auther d
 * @Date 2022/2/19 17:49
 * @Describe
 **/
public class B extends A{
    public B() {
        this(8);
        System.out.println("B的空参构造器");
    }
    public B(int a){
        System.out.println("B的有参构造器");
    }
}
