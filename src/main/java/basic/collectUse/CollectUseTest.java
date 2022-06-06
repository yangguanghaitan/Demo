package basic.collectUse;

import net.sf.cglib.core.CollectionUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther d
 * @Date 2022/6/6 17:01
 * @Describe 集合使用测试
 **/

public class CollectUseTest {


    //集合转map,value为空时，报npe
    @Test
    public void collectToMap() {
        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack", "18163138123"));
        bookList.add(new Person("martin", null));
        System.out.println(bookList);
        bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));
    }

    //集合遍历删除，使用iterator(有风险)，推荐java.util.Collection.removeIf
    @Test
    public void collectForeachRemove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }
        list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
        System.out.println(list); /* [1, 3, 5, 7, 9] */
    }

    //集合去重
    @Test
    public void collectRemoverepeat() {
        removeDuplicateBySet(null);//推荐此种，效率高
        removeDuplicateByList(null);
    }
    //集合转数组
    @Test
    public void collectToArray() {
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        System.out.println("反转前 :"+list);
        Collections.reverse(list);
        System.out.println("反转后 :"+list);
        //集合转数组，没有指定类型的话会报错
        s=list.toArray(new String[0]);
        System.out.println("集合转数组 :"+s);
        System.out.println("数组打印 "+Arrays.toString(s));
    }


    //数组转集合 Arrays.asList()参数是基本数据类型时，有的方法会报错(不推荐此种方式进行转换)
    @Test
    public void arrayToCollect1() {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        System.out.println(myList.size() + "=" + myList.get(2));
        System.out.println("myList数据 "+myList);
        //上面两个语句等价于下面一条语句
        List<String> myList2 = Arrays.asList("Apple","Banana", "Orange");
        System.out.println("myList2数据 "+myList2);



    }

    //数组转集合,(推荐)
    @Test
    public void arrayToCollect2() {
        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println(list);
    }

    //数组转集合,(Java8 stream更推荐)
    @Test
    public void arrayToCollect3() {
        Integer [] myArray = { 1, 2, 3 };
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList);
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        List myList2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        System.out.println(myList2);

    }



    // Set 去重代码示例
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        if (data.isEmpty()) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    // List 去重代码示例
    public static <T> List<T> removeDuplicateByList(List<T> data) {

        if (data.isEmpty()) {
            return new ArrayList<>();

        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }

}

    class Person {
        private String name;
        private String phoneNumber;

        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }