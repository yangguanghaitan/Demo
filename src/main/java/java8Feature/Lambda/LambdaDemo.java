package java8Feature.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther d
 * @Date 2022/1/28 11:27
 * @Describe Lambda 表达式的深入,本例测试{@link Runnable,Comparator},注意泛型,注意多条语句要加{},
 **/
public class LambdaDemo {
    public static void main(String[] args) {
        //1.Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The runable now is not using!");
            }
        }).start();
        new Thread(() -> System.out.println("The runable now is using!")).start();
        //2.Comperator
        List<Integer> strings = Arrays.asList(1, 3, 4, 2);
        Collections.sort(strings, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("The Comperator now is not using!" + strings);
        Comparator<Integer> comparator = (o1, o2) -> {
            return o2 - o1;
        };
        Collections.sort(strings, comparator);
        System.out.println("The Comperator now is  using!" + strings);
        Collections.sort(strings, (Integer o1, Integer o2) -> {return o1 - o2;});
        System.out.println("The Comperator now is  using!" + strings);


    }


}
