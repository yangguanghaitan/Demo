package java8Feature.Lambda.accept;

/**
 * @Auther d
 * @Date 2022/1/28 13:07
 * @Describe 有输入,无输出Conumer模式
 **/
public class AcceptDemo {
    private static Integer num=90;

    public static void main(String[] args) {
              //第一种
              AcceptObject<Integer> acceptObject=(o1)-> System.out.println(o1+5);
              accept(acceptObject);
              //第二种
              accept((o1)->{System.out.println(o1+10);});
              //第三种
              accept((o1)->System.out.println(o1+20));
    }

    public static void accept(AcceptObject<Integer> acceptObject){
        acceptObject.accept(num);
    }
}
