package guide.reference;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java只有值引用，如果是引用类型，传递的只是地址值的拷贝，不会对原本数据产生影响
//                如果是基本类型，传递的是值的字面量的拷贝
public class ValueReference {

    @Test
    public void ee(){
        //值引用的一部分
        int[] aa=new int[5];
        int[] bb=aa;
        bb[0]=8;
        System.out.println(Arrays.toString(aa));
        System.out.println(Arrays.toString(bb));
    }

    @Test
    public  void dd() {
        List list1=new ArrayList();
        list1.add(45);
        List list2=new ArrayList();
        list2.add(88);
        swap(list1,list2);
        System.out.println(list1);
        System.out.println(list2);
    }

    public static void swap(List list1, List list2) {
        List temp = list1;
        list1 = list2;
        list2 = temp;
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
    }



    @Test
    public  void cc() {
        Person xiaoZhang = new Person("小张");
        Person xiaoLi = new Person("小李");
        swap(xiaoZhang, xiaoLi);
        System.out.println("xiaoZhang:" + xiaoZhang.getName());//小张
        System.out.println("xiaoLi:" + xiaoLi.getName());//小李
    }

    public static void swap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("person1:" + person1.getName());//小李
        System.out.println("person2:" + person2.getName());//小张
    }
    public static class Person {
        private String name;

        public Person(String s) {
            this.name=s;
        }

        public String getName() {
            return name;
        }
    }


    @Test
    public  void bb() {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        add(list);
        System.out.println(list);
    }
     public static void add(List list){
        list.add(00);
        list.add(99);
     }


    @Test
    public  void aa() {
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);
        System.out.println("num1 = " + num1);//10
        System.out.println("num2 = " + num2);//20
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);//20
        System.out.println("b = " + b);//10
    }
}
