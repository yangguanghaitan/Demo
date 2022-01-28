package java8Feature.Lambda.get;

/**
 * @Auther d
 * @Date 2022/1/28 13:32
 * @Describe 有输出无输入模式
 **/
public class GetDemo {

    public static void main(String[] args) {
        //第一种
        GetObject<Integer> getObject=()->{return 89;};
        get(getObject);
        //第二种
        get(()->{return  90;});
    }

    public static void get(GetObject<Integer> getObject){
        Integer get = getObject.get();
        System.out.println(get);

    }
}
