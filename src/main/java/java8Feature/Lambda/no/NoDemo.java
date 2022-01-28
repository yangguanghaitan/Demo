package java8Feature.Lambda.no;

/**
 * @Auther d
 * @Date 2022/1/28 12:41
 * @Describe 无接受值,无返回值
 **/
public class NoDemo {
    public static void main(String[] args) {
        //第一种
        NoObject noObject=()->System.out.println(90909);
        no(noObject);
        //第二种
        no(()-> System.out.println(666));

    }
    static void no(NoObject noObject){
        noObject.no();
    }
}
