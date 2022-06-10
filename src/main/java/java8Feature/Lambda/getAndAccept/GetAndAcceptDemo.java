package java8Feature.Lambda.getAndAccept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther d
 * @Date 2022/6/10 10:04
 * @Describe 测试方法的返回值是函数式接口的lambda的用法，会通过泛型定义输入输出的参数类型
 **/
public class GetAndAcceptDemo {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("111", 222);

        //test1()测试
        /*List list = test1().apply(map);
        System.out.println(list);
*/
        //test2()测试，可以用
        List apply = test2().apply(map);
        System.out.println(apply);

    }


    //可以
    public static LamFunction test2() {
        return ab -> {
            ab.put("aa", "bb");
            ArrayList<Object> list = new ArrayList<>();
            list.add(ab);
            return list;
        };
    }

    //可以
    public static LamFunction test1() {
        return new LamFunction() {
            @Override
            public List apply(Map map) {
                List list = new ArrayList();
                list.add(map);
                return list;
            }
        };
    }
}
