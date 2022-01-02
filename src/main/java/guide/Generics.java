package guide;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//常用的通配符为： T，E，K，V，？
//？ 表示不确定的 Java 类型
//T (type) 表示具体的一个 Java 类型
//K V (key value) 分别代表 Java 键值中的 Key Value
//E (element) 代表 Element
public class Generics {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(12);
//这里直接添加会报错
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//但是通过反射添加是可以的
//这就说明在运行期间所有的泛型信息都会被擦掉
        add.invoke(list, "kl");
        System.out.println(list);
    }
}
